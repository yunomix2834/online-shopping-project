package com.gatewayserver.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ReactiveJwtEntryPoint implements ServerAuthenticationEntryPoint {

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public Mono<Void> commence(
      ServerWebExchange exchange,
      AuthenticationException authenticationException) {
    ErrorCode code = ErrorCode.UNAUTHENTICATED;
    Envelope<Void> envelope = Envelope.err(
        code.http(),
        code.name(),
        code.getMessage(),
        null
    );

    ServerHttpResponse response = exchange.getResponse();
    response.setStatusCode(HttpStatus.valueOf(code.http()));
    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
    return response.writeWith(Mono.fromSupplier(() -> {
      try {
        byte[] bytes = mapper.writeValueAsBytes(envelope);
        return response.bufferFactory().wrap(bytes);
      } catch (Exception e) {
        return response.bufferFactory().wrap(new byte[0]);
      }
    }));
  }
}
