package com.core.configuration.security;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.security.authentication.BearerAuthenticationReader;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;


@Configuration
@RequiredArgsConstructor
public class GrpcServerSecurityConfig  {


  private final GrpcReactiveJwtDecoder reactiveJwtDecoder;

  /**
   * Đọc token từ metadata "Authorization: Bearer <token>"
   * Cho gRPC server.
   */
  @Bean
  public GrpcAuthenticationReader grpcAuthenticationReader() {
    return new BearerAuthenticationReader(
        accessToken -> new BearerTokenAuthenticationToken(accessToken)
    );
  }

  /**
   * Wrapper: dùng ReactiveJwtDecoder hiện có, nhưng block để dùng cho gRPC (blocking).
   */
  @Bean
  public JwtDecoder grpcJwtDecoder() {
    return token -> reactiveJwtDecoder.decode(token).block();
  }

  /**
   * AuthenticationManager dùng JWT:
   *  - verify token với grpcJwtDecoder
   *  - map "roles" -> authorities
   *  - principal = "userId"
   *
   * net.devh sẽ tự động dùng AuthenticationManager này cho gRPC.
   */
  @Bean
  public AuthenticationManager grpcAuthenticationManager(JwtDecoder grpcJwtDecoder) {
    // giống config reactive: claim "roles", không prefix "ROLE_"
    JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
    authoritiesConverter.setAuthoritiesClaimName("roles");
    authoritiesConverter.setAuthorityPrefix("");

    JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();
    jwtAuthConverter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
    jwtAuthConverter.setPrincipalClaimName("userId");

    JwtAuthenticationProvider provider = new JwtAuthenticationProvider(grpcJwtDecoder);
    provider.setJwtAuthenticationConverter(jwtAuthConverter);

    return new ProviderManager(List.of(provider));
  }
}
