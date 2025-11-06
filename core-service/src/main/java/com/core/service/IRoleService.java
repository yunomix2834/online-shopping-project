package com.core.service;


import com.core.dto.request.user.AssignRoleRequestDto;
import com.core.dto.request.user.CreateRoleRequestDto;
import com.core.dto.response.user.MeResponseDto;
import com.core.dto.response.user.RoleResponseDto;
import org.common.http.Envelope;

public interface IRoleService {
    void create(CreateRoleRequestDto req);

    void softDelete(String roleName);

    void restore(String roleName);

    void assign(AssignRoleRequestDto req);

    void remove(AssignRoleRequestDto req);

    Envelope.Page<RoleResponseDto> listUserRoles(
            String userId,
            int page, int size);

    Envelope.Page<MeResponseDto> listUsersByRole(
            String roleName,
            int page, int size);

    Envelope.Page<RoleResponseDto> listAllRoles(
            int page, int size);
}