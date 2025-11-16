package com.core.configuration.interceptor;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import net.devh.boot.grpc.client.interceptor.GlobalClientInterceptorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;

@Configuration
public class GrpcJwtClientPropagationConfig {

  @Bean
  public GlobalClientInterceptorConfigurer jwtPropagationConfigurer() {
    return interceptors -> interceptors.add(
        new JwtPropagatingClientInterceptor());
  }

  static class JwtPropagatingClientInterceptor implements ClientInterceptor {
    private static final Metadata.Key<String> AUTH =
        Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method,
        CallOptions callOptions,
        Channel next) {

      return new ForwardingClientCall.SimpleForwardingClientCall<>(next.newCall(method, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          String token = resolveToken();
          if (token != null && !token.isBlank()) {
            headers.put(AUTH, "Bearer " + token);
          }
          super.start(responseListener, headers);
        }
      };
    }

    private String resolveToken() {
      var ctx = SecurityContextHolder.getContext();
      if (ctx == null || ctx.getAuthentication() == null) return null;
      if (ctx.getAuthentication() instanceof BearerTokenAuthentication b) {
        return b.getToken().getTokenValue();
      }
      return null;
    }
  }
}
