package com.core.controller.gateway;

import com.common.grpc.ToggleActiveRequest;
import com.common.grpc.UpdateProfileRequest;
import com.common.grpc.UserServiceGrpc;
import com.core.dto.request.gateway.user.UpdateProfileRequestBody;
import com.core.dto.response.gateway.user.MeResponseView;
import com.core.helper.GrpcHelper;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  @GrpcClient("core")
  private Channel coreChannel;

  @PostMapping("/toggle-active")
  public Mono<ResponseEntity<Envelope<Void>>> toggleActive(
      @RequestParam String userId,
      @RequestParam boolean active) {
    return GrpcHelper.callGrpcVoid(
        coreChannel,
        UserServiceGrpc::newBlockingStub,
        stub -> stub.toggleActive(ToggleActiveRequest.newBuilder()
            .setUserId(userId)
            .setActive(active)
            .build()));
  }

  @GetMapping("/me")
  public Mono<ResponseEntity<Envelope<MeResponseView>>> me() {
    return GrpcHelper.callGrpc(
        coreChannel,
        UserServiceGrpc::newBlockingStub,
        stub -> stub.getMe(Empty.getDefaultInstance()),
        resp -> new MeResponseView(
            resp.getId(),
            resp.getUsername(),
            resp.getEmail(),
            resp.getFullName().isBlank() ? null : resp.getFullName(),
            resp.getPhoneNumber().isBlank() ? null : resp.getPhoneNumber(),
            resp.getIsActive(),
            resp.getIsVerified()
        )
    );
  }

  @PatchMapping("/me")
  public Mono<ResponseEntity<Envelope<Void>>> update(
      @RequestBody UpdateProfileRequestBody body) {
    String fullName = body.fullName() == null ? "" : body.fullName();
    String phone = body.phoneNumber() == null ? "" : body.phoneNumber();

    return GrpcHelper.callGrpcVoid(
        coreChannel,
        UserServiceGrpc::newBlockingStub,
        stub -> stub.updateProfile(UpdateProfileRequest.newBuilder()
            .setFullName(fullName)
            .setPhoneNumber(phone)
            .build()));
  }
}
