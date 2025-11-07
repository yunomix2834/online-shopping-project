package com.gatewayserver.controller;

import com.common.grpc.AssignRoleRequest;
import com.common.grpc.CreateRoleRequest;
import com.common.grpc.PageRequest;
import com.common.grpc.RoleName;
import com.common.grpc.RoleServiceGrpc;
import com.gatewayserver.dto.request.user.AssignRoleRequestBody;
import com.gatewayserver.dto.request.user.CreateRoleRequestBody;
import com.gatewayserver.dto.response.user.RoleResponseView;
import com.gatewayserver.helper.GrpcHelper;
import io.grpc.Channel;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    @GrpcClient("core")
    private Channel coreChannel;

    @PostMapping
    public Mono<ResponseEntity<Envelope<Void>>> create(
            @RequestBody CreateRoleRequestBody body){
        return GrpcHelper.callGrpcVoid(
                coreChannel,
                RoleServiceGrpc::newBlockingStub,
                stub -> stub.create(CreateRoleRequest.newBuilder()
                        .setName(body.name())
                        .build()));
    }

    @DeleteMapping("/{name}")
    public Mono<ResponseEntity<Envelope<Void>>> softDelete(
            @PathVariable String name){
        return GrpcHelper.callGrpcVoid(
                coreChannel,
                RoleServiceGrpc::newBlockingStub,
                stub -> stub.softDelete(RoleName.newBuilder()
                        .setName(name)
                        .build()));
    }

    @PostMapping("/{name}/restore")
    public Mono<ResponseEntity<Envelope<Void>>> restore(
            @PathVariable String name){
        return GrpcHelper.callGrpcVoid(
                coreChannel,
                RoleServiceGrpc::newBlockingStub,
                stub -> stub.restore(RoleName.newBuilder()
                        .setName(name)
                        .build()));
    }

    @PostMapping("/assign")
    public Mono<ResponseEntity<Envelope<Void>>> assign(
            @RequestBody AssignRoleRequestBody body){
        return GrpcHelper.callGrpcVoid(
                coreChannel,
                RoleServiceGrpc::newBlockingStub,
                stub -> stub.assign(AssignRoleRequest.newBuilder()
                        .setUserId(body.userId())
                        .setRoleName(body.roleName())
                        .build()));
    }

    @PostMapping("/remove")
    public Mono<ResponseEntity<Envelope<Void>>> remove(
            @RequestBody AssignRoleRequestBody body){
        return GrpcHelper.callGrpcVoid(
                coreChannel,
                RoleServiceGrpc::newBlockingStub,
                stub -> stub.remove(AssignRoleRequest.newBuilder()
                        .setUserId(body.userId())
                        .setRoleName(body.roleName())
                        .build()));
    }

    @GetMapping("/user/{userId}")
    public Mono<ResponseEntity<Envelope<Envelope.Page<RoleResponseView>>>> listUserRoles(
            @PathVariable String userId){
        return GrpcHelper.callGrpc(
                coreChannel,
                RoleServiceGrpc::newBlockingStub,
                stub -> stub.listUserRoles(AssignRoleRequest.newBuilder()
                        .setUserId(userId)
                        .build()),
                p -> Envelope.Page.<RoleResponseView>builder()
                        .page(p.getPage())
                        .size(p.getSize())
                        .total(p.getTotal())
                        .totalPages(p.getTotalPages())
                        .docs(p.getDocsList().stream()
                                .map(d -> new RoleResponseView(d.getName()))
                                .toList())
                        .build());
    }

    @GetMapping
    public Mono<ResponseEntity<Envelope<Envelope.Page<RoleResponseView>>>> listAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size){
        return GrpcHelper.callGrpc(
                coreChannel,
                RoleServiceGrpc::newBlockingStub,
                stub -> stub.listAll(PageRequest.newBuilder()
                        .setPage(page)
                        .setSize(size)
                        .build()),
                p -> Envelope.Page.<RoleResponseView>builder()
                        .page(p.getPage())
                        .size(p.getSize())
                        .total(p.getTotal())
                        .totalPages(p.getTotalPages())
                        .docs(p.getDocsList().stream()
                                .map(d -> new RoleResponseView(d.getName()))
                                .toList())
                        .build());
    }
}