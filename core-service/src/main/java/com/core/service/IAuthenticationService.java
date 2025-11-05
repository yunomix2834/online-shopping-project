package com.core.service;

import com.core.dto.request.AuthenticationRequestDto;
import com.core.dto.request.IntrospectRequestDto;
import com.core.dto.request.RefreshRequestDto;
import com.core.dto.request.UserCreationRequestDto;
import com.core.dto.response.AuthenticationResponseDto;
import com.core.dto.response.IntrospectResponseDto;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface IAuthenticationService {

    /**
     * Đăng ký người dùng mới chưa kích hoạt và gửi mã OTP.
     *
     * @param request thông tin user để đăng ký
     */
    void register(UserCreationRequestDto request);

    /**
     * Đăng nhập bằng username hoặc email, kiểm tra mật khẩu và sinh JWT.
     *
     * @param request thông tin đăng nhập
     * @return AuthenticationResponse chứa accessToken và thông tin user
     * @throws ParseException khi lỗi parse JWT
     */
    AuthenticationResponseDto login(AuthenticationRequestDto request)
            throws ParseException;

    /**
     * Đăng xuất, invalid token bằng cách lưu vào repository.
     *
     * @param token chứa token cần logout
     * @throws ParseException khi lỗi parse JWT
     * @throws JOSEException  khi lỗi verify JWT
     */
    void logout(String token)
            throws ParseException, JOSEException;

    /**
     * Kiểm tra tính hợp lệ của token mà không ném exception.
     *
     * @param request đối tượng chứa token cần kiểm tra
     * @return IntrospectResponse với flag valid
     * @throws JOSEException  khi lỗi ký JWT
     * @throws ParseException khi lỗi parse JWT
     */
    IntrospectResponseDto introspect(IntrospectRequestDto request)
            throws JOSEException, ParseException;

    /**
     * Làm mới access token từ refresh token.
     *
     * @param request chứa token cũ
     * @return AuthenticationResponse chứa token mới và expiryTime
     * @throws ParseException khi lỗi parse JWT
     * @throws JOSEException  khi lỗi verify JWT
     */
    AuthenticationResponseDto refreshToken(RefreshRequestDto request)
            throws ParseException, JOSEException;
}
