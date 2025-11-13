package com.core.controller;

import com.common.grpc.AssignRoleRequest;
import com.common.grpc.CreateRoleRequest;
import com.common.grpc.MeLite;
import com.common.grpc.PageRequest;
import com.common.grpc.PageRole;
import com.common.grpc.PageUser;
import com.common.grpc.RoleName;
import com.common.grpc.RoleResponse;
import com.common.grpc.RoleServiceGrpc;
import com.core.dto.request.user.AssignRoleRequestDto;
import com.core.dto.request.user.CreateRoleRequestDto;
import com.core.dto.response.user.MeResponseDto;
import com.core.dto.response.user.RoleResponseDto;
import com.core.service.IRoleService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.GrpcStatusMapper;
import org.common.http.Envelope;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleGrpcController extends RoleServiceGrpc.RoleServiceImplBase {
    private final IRoleService roleService;

    @Override
    public void create(
            CreateRoleRequest r,
            StreamObserver<Empty> responseObserver){
        roleService.create(CreateRoleRequestDto.builder()
                .name(r.getName())
                .build());
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override
    public void softDelete(
            RoleName r,
            StreamObserver<Empty> responseObserver){
        roleService.softDelete(r.getName());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override public void restore(
            RoleName r,
            StreamObserver<Empty> responseObserver){
        roleService.restore(r.getName());
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override
    public void assign(
            AssignRoleRequest r,
            StreamObserver<Empty> responseObserver){
        AssignRoleRequestDto dto = AssignRoleRequestDto.builder()
                .userId(r.getUserId())
                .roleName(r.getRoleName())
                .build();
        roleService.assign(dto);
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override
    public void remove(
            AssignRoleRequest r,
            StreamObserver<Empty> responseObserver){
        AssignRoleRequestDto dto = AssignRoleRequestDto.builder()
                .userId(r.getUserId())
                .roleName(r.getRoleName())
                .build();
        roleService.remove(dto);
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void listUserRoles(
            AssignRoleRequest r,
            StreamObserver<PageRole> responseObserver) {
        Envelope.Page<RoleResponseDto> page = roleService.listUserRoles(
                r.getUserId(), 0, Integer.MAX_VALUE);
        PageRole.Builder builder = PageRole.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());

        page.getDocs().forEach(rr -> builder.addDocs(
                RoleResponse.newBuilder()
                        .setName(rr.getName())
                        .build()));

        GrpcStatusMapper.ok(responseObserver, builder.build());
    }

    @Override
    public void listUsersByRole(
            RoleName r,
            StreamObserver<PageUser> responseObserver) {
        Envelope.Page<MeResponseDto> page = roleService.listUsersByRole(
                r.getName(),0, Integer.MAX_VALUE);
        PageUser.Builder b = PageUser.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());
        page.getDocs().forEach(m -> b.addDocs(
                MeLite.newBuilder().setId(m.getId())
                        .setUsername(m.getUsername())
                        .setEmail(m.getEmail())
                        .setFullName(m.getFullName() == null
                                ? ""
                                : m.getFullName())
                        .build()));

        GrpcStatusMapper.ok(responseObserver, b.build());
    }

    @Override
    public void listAll(
            PageRequest r,
            StreamObserver<PageRole> responseObserver) {
        Envelope.Page<RoleResponseDto> page = roleService.listAllRoles(
                r.getPage(), r.getSize());
        PageRole.Builder b = PageRole.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());
        page.getDocs().forEach(rr -> b.addDocs(RoleResponse.newBuilder()
                .setName(rr.getName())
                .build()));

        GrpcStatusMapper.ok(responseObserver, b.build());
    }
}
