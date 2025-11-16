package com.core.service.impl;

import com.core.dto.request.user.UpdateProfileRequestDto;
import com.core.dto.response.user.MeResponseDto;
import com.core.entity.User;
import com.core.helper.AuthenticationHelper;
import com.core.helper.UserHelper;
import com.core.mapper.user.UserProfileMapper;
import com.core.repository.UserRepository;
import com.core.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.security.RequireAdmin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserServiceImpl implements IUserService {
  UserRepository userRepository;
  UserHelper userHelper;
  UserProfileMapper userProfileMapper;

  @Override
  @Transactional
  @RequireAdmin
  public void toggleActive(
      String userId,
      boolean active) {
    User u = userHelper.getUserById(userId);
    u.setIsActive(active);
    userRepository.save(u);
  }

  @Override
  @Transactional(readOnly = true)
  public MeResponseDto getMe() {
    String me = AuthenticationHelper.getMyUserId();
    return userRepository.findById(me)
        .map(userProfileMapper::toMeResponseDtoFromUser)
        .orElseThrow(
            () -> new AppException(ErrorCode.RESOURCE_NOT_FOUND)
        );
  }

  @Override
  @Transactional
  public void updateProfile(
      UpdateProfileRequestDto request) {
    String me = AuthenticationHelper.getMyUserId();
    User u = userHelper.getUserById(me);
    userProfileMapper.patchUserFromUpdateProfileRequestDto(u,
        request);
    userRepository.save(u);
  }
}
