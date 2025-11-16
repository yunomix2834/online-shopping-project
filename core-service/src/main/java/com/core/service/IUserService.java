package com.core.service;


import com.core.dto.request.user.UpdateProfileRequestDto;
import com.core.dto.response.user.MeResponseDto;

public interface IUserService {
  void toggleActive(String userId,
                    boolean active);

  MeResponseDto getMe();

  void updateProfile(UpdateProfileRequestDto req);
}
