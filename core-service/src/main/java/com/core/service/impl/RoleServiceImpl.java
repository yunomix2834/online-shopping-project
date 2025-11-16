package com.core.service.impl;

import com.core.dto.request.user.AssignRoleRequestDto;
import com.core.dto.request.user.CreateRoleRequestDto;
import com.core.dto.response.user.MeResponseDto;
import com.core.dto.response.user.RoleResponseDto;
import com.core.entity.Role;
import com.core.entity.User;
import com.core.helper.AuthenticationHelper;
import com.core.helper.UserHelper;
import com.core.mapper.user.UserProfileMapper;
import com.core.repository.UserRepository;
import com.core.repository.user.RoleRepository;
import com.core.service.IRoleService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.common.security.RequireAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleServiceImpl implements IRoleService {
  RoleRepository roleRepository;
  UserRepository userRepository;
  UserHelper userHelper;
  UserProfileMapper userProfileMapper;

  @Override
  @Transactional
  @RequireAdmin
  public void create(CreateRoleRequestDto request) {
    if (roleRepository.existsById(request.getName())) {
      throw new AppException(ErrorCode.RESOURCE_ALREADY_EXISTS);
    }
    Role r = Role.builder()
        .name(request.getName())
        .build();
    roleRepository.save(r);
  }

  @Override
  @Transactional
  @RequireAdmin
  public void softDelete(
      String roleName) {
    Role r = roleRepository.findById(roleName)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    r.markDeleted(AuthenticationHelper.getMyUserId());
    roleRepository.save(r);
  }

  @Override
  @Transactional
  @RequireAdmin
  public void restore(String roleName) {
    roleRepository.findById(roleName)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    int n = roleRepository.nativeRestore(roleName);
    if (n == 0) {
      throw new AppException(ErrorCode.RESOURCE_NOT_FOUND);
    }
  }

  @Override
  @Transactional
  @RequireAdmin
  public void assign(AssignRoleRequestDto request) {
    User u = userHelper.getUserById(request.getUserId());
    Role r = roleRepository.findById(request.getRoleName())
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    u.getRoles().add(r);
    userRepository.save(u);
  }

  @Override
  @Transactional
  @RequireAdmin
  public void remove(AssignRoleRequestDto request) {
    User u = userHelper.getUserById(request.getUserId());
    u.getRoles().removeIf(role -> role.getName()
        .equals(request.getRoleName()));
    userRepository.save(u);
  }

  @Override
  @Transactional(readOnly = true)
  public Envelope.Page<RoleResponseDto> listUserRoles(
      String userId,
      int page,
      int size) {
    User u = userHelper.getUserById(userId);
    List<RoleResponseDto> docs = u.getRoles().stream()
        .map(r -> RoleResponseDto.builder()
            .name(r.getName())
            .build())
        .toList();
    return Envelope.Page.<RoleResponseDto>builder()
        .page(page)
        .size(size)
        .total(docs.size())
        .totalPages(1)
        .docs(docs)
        .build();
  }

  @Override
  @Transactional(readOnly = true)
  public Envelope.Page<MeResponseDto> listUsersByRole(
      String roleName,
      int page,
      int size) {
    Pageable pageable = PageRequest.of(
        page,
        size,
        Sort.by("createdAt").descending()
    );
    Page<User> p = userRepository.findAll(pageable)
        .map(u -> u.getRoles()
            .stream()
            .anyMatch(r -> r.getName().equals(roleName))
            ? u
            : null);
    List<MeResponseDto> docs = p.getContent()
        .stream()
        .filter(u -> u != null)
        .map(userProfileMapper::toMeResponseDtoFromUser)
        .toList();
    return Envelope.Page.<MeResponseDto>builder()
        .page(page)
        .size(size)
        .total(docs.size())
        .totalPages(p.getTotalPages() == 0
            ? 1
            : p.getTotalPages())
        .docs(docs)
        .build();
  }

  @Override
  @Transactional(readOnly = true)
  public Envelope.Page<RoleResponseDto> listAllRoles(
      int page,
      int size) {
    Pageable pageable = PageRequest.of(page,
        size);
    Page<Role> p = roleRepository.findAll(pageable);
    List<RoleResponseDto> docs = p.stream()
        .map(r -> RoleResponseDto.builder()
            .name(r.getName())
            .build())
        .toList();
    return Envelope.Page.<RoleResponseDto>builder()
        .page(page)
        .size(size)
        .total(p.getTotalElements())
        .totalPages(p.getTotalPages())
        .docs(docs)
        .build();
  }
}
