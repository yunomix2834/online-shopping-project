package com.core.service.impl;

import com.core.dto.request.authentication.AuthenticationRequestDto;
import com.core.dto.request.authentication.IntrospectRequestDto;
import com.core.dto.request.authentication.RefreshRequestDto;
import com.core.dto.request.authentication.UserCreationRequestDto;
import com.core.dto.response.authentication.AuthenticationResponseDto;
import com.core.dto.response.authentication.IntrospectResponseDto;
import com.core.entity.InvalidatedToken;
import com.core.entity.Role;
import com.core.entity.User;
import com.core.mapper.user.UserMapper;
import com.core.repository.InvalidatedTokenRepository;
import com.core.repository.UserRepository;
import com.core.repository.user.RoleRepository;
import com.core.service.IAuthenticationService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationServiceImpl
    implements IAuthenticationService {

  UserRepository userRepository;
  RoleRepository roleRepository;
  InvalidatedTokenRepository invalidatedTokenRepository;

  UserMapper userMapper;

  PasswordEncoder passwordEncoder;

  @NonFinal
  @Value("${app.jwt.signerKey}")
  protected String SIGNER_KEY;

  @NonFinal
  @Value("${app.jwt.valid-duration}")
  protected long VALID_DURATION;

  @NonFinal
  @Value("${app.jwt.refreshable-duration}")
  protected long REFRESH_DURATION;

  /**
   * Đăng ký người dùng mới chưa kích hoạt và gửi mã OTP.
   *
   * @param request thông tin user để đăng ký
   */
  @Transactional
  @Override
  public void register(
      UserCreationRequestDto request) {
    if (userRepository.existsByUsername(request.getUsername())) {
      throw new AppException(ErrorCode.RESOURCE_ALREADY_EXISTS);
    }

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new AppException(ErrorCode.RESOURCE_ALREADY_EXISTS);
    }

    User user = userMapper.toUserFromUserCreationRequestDto(request);
    user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
    user.setRoles(new HashSet<>());
    roleRepository.findById("USER")
        .ifPresent(r -> user.getRoles().add(r));

    user.setIsActive(true);
    user.setIsVerified(false);
    userRepository.save(user);
  }

  /**
   * Đăng nhập bằng username hoặc email, kiểm tra mật khẩu và sinh JWT.
   *
   * @param request thông tin đăng nhập
   * @return AuthenticationResponse chứa accessToken và thông tin user
   * @throws ParseException khi lỗi parse JWT
   */
  @Override
  public AuthenticationResponseDto login(
      AuthenticationRequestDto request)
      throws
      ParseException {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    User user = userRepository
        .findByUsernameOrEmail(request.getUsername(),
            request.getEmail())
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

    boolean authenticated = passwordEncoder.matches(
        request.getPassword(),
        user.getPasswordHash()
    );

    if (!authenticated) {
      throw new AppException(ErrorCode.INVALID_CREDENTIALS);
    }

    return generateTokenAndReturnAuthenticationResponse(user);
  }

  /**
   * Đăng xuất, invalid token bằng cách lưu vào repository.
   *
   * @param token chứa token cần logout
   * @throws ParseException khi lỗi parse JWT
   * @throws JOSEException  khi lỗi verify JWT
   */
  @Override
  public void logout(String token)
      throws
      ParseException,
      JOSEException {
    try {
      SignedJWT signToken = verifyToken(token,
          true);

      invalidateToken(signToken);
    } catch (AppException e) {
      log.info("Token already expired");
    }
  }

  /**
   * Kiểm tra tính hợp lệ của token mà không ném exception.
   *
   * @param request đối tượng chứa token cần kiểm tra
   * @return IntrospectResponse với flag valid
   * @throws JOSEException  khi lỗi ký JWT
   * @throws ParseException khi lỗi parse JWT
   */
  @Override
  public IntrospectResponseDto introspect(
      IntrospectRequestDto request)
      throws
      JOSEException,
      ParseException {
    String token = request.getToken();
    boolean isValid = true;
    String userId = null;

    try {
      SignedJWT signedJWT = verifyToken(token,
          false);

      userId = signedJWT.getJWTClaimsSet().getStringClaim("userId");
    } catch (AppException e) {
      isValid = false;
    }

    return IntrospectResponseDto.builder()
        .valid(isValid)
        .userId(userId)
        .build();
  }

  /**
   * Làm mới access token từ refresh token.
   *
   * @param request chứa token cũ
   * @return AuthenticationResponse chứa token mới và expiryTime
   * @throws ParseException khi lỗi parse JWT
   * @throws JOSEException  khi lỗi verify JWT
   */
  @Override
  public AuthenticationResponseDto refreshToken(RefreshRequestDto request)
      throws
      ParseException,
      JOSEException {
    SignedJWT signedJWT = verifyToken(request.getToken(),
        true);

    invalidateToken(signedJWT);

    User user = userRepository
        .findById(signedJWT.getJWTClaimsSet().getSubject())
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

    return generateTokenAndReturnAuthenticationResponse(user);
  }

  private SignedJWT generateToken(
      User user,
      long duration,
      String type) {
    JWSHeader header = new JWSHeader
        .Builder(JWSAlgorithm.HS512)
        .type(JOSEObjectType.JWT)
        .build();

    JWTClaimsSet jwtClaimsSet = buildJwtClaimsSet(user,
        duration,
        type);

    SignedJWT signedJWT = new SignedJWT(header,
        jwtClaimsSet);

    try {
      JWSSigner signer =
          new MACSigner(SIGNER_KEY.getBytes(StandardCharsets.UTF_8));
      signedJWT.sign(signer);

      return signedJWT;
    } catch (JOSEException e) {
      log.error("Cannot create token",
          e);
      throw new AppException(ErrorCode.FAILED_GENERATE_TOKEN);
    }
  }

  private JWTClaimsSet buildJwtClaimsSet(
      User user,
      long duration,
      String type) {
    Instant expiryInstant = Instant.now()
        .plus(duration,
            ChronoUnit.SECONDS);

    JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder()
        .subject(user.getId())
        .issuer("Code Campus")
        .issueTime(new Date())
        .expirationTime(Date.from(expiryInstant))
        .jwtID(UUID.randomUUID().toString())
        .claim("userId",
            user.getId())
        .claim("roles",
            user.getRoles()
                .stream()
                .map(Role::getName)
                .toList()
        )
        .claim("token_type",
            type);

    return builder.build();
  }

  private SignedJWT verifyToken(
      String token,
      boolean isRefresh)
      throws
      JOSEException,
      ParseException {
    SignedJWT signedJWT = SignedJWT.parse(token);

    Date expiryTime = isRefresh
        ? Date.from(signedJWT.getJWTClaimsSet()
        .getIssueTime()       // thời điểm phát hành
        .toInstant()
        .plus(REFRESH_DURATION,
            ChronoUnit.SECONDS))
        : signedJWT.getJWTClaimsSet().getExpirationTime();

    boolean verified = signedJWT.verify(
        new MACVerifier(SIGNER_KEY.getBytes(StandardCharsets.UTF_8)));

    if (!(verified && expiryTime.after(new Date()))) {
      throw new AppException(ErrorCode.UNAUTHENTICATED);
    }

    if (invalidatedTokenRepository.existsById(
        signedJWT.getJWTClaimsSet().getJWTID())) {
      throw new AppException(ErrorCode.TOKEN_REVOKED);
    }

    return signedJWT;
  }

  private void invalidateToken(SignedJWT signedJWT)
      throws
      ParseException {
    String jit = signedJWT.getJWTClaimsSet().getJWTID();
    Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

    InvalidatedToken invalidatedToken = InvalidatedToken.builder()
        .id(jit)
        .expiryTime(expiryTime.toInstant())
        .build();

    invalidatedTokenRepository.save(invalidatedToken);
  }

  private AuthenticationResponseDto generateTokenAndReturnAuthenticationResponse(
      User user)
      throws
      ParseException {
    SignedJWT accessToken =
        generateToken(user,
            VALID_DURATION,
            "access_token");
    SignedJWT refreshToken =
        generateToken(user,
            REFRESH_DURATION,
            "refresh_token");

    return AuthenticationResponseDto.builder()
        .accessToken(accessToken.serialize())
        .refreshToken(refreshToken.serialize())
        .accessExpiry(accessToken.getJWTClaimsSet().getExpirationTime()
            .toInstant())
        .refreshExpiry(
            refreshToken.getJWTClaimsSet().getExpirationTime()
                .toInstant())
        .build();
  }
}
