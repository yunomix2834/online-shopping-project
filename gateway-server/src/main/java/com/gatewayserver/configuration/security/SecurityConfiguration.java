package com.gatewayserver.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtGrantedAuthoritiesConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.common.constant.SecurityConstants.PUBLIC_ENDPOINTS;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final GrpcReactiveJwtDecoder jwtDecoder;
    private final ReactiveJwtEntryPoint entryPoint;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(
            ServerHttpSecurity http) {
        return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(ex -> ex
                        .pathMatchers(PUBLIC_ENDPOINTS).permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer(oauth -> oauth.jwt(j -> j
                                .jwtDecoder(jwtDecoder)
                                .jwtAuthenticationConverter(reactiveJwtConverter())
                    )
                        .authenticationEntryPoint(entryPoint))
                .build();
    }

  @Bean
  public ReactiveJwtAuthenticationConverter reactiveJwtConverter() {
    JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
    authoritiesConverter.setAuthoritiesClaimName("roles");
    authoritiesConverter.setAuthorityPrefix("");

    ReactiveJwtAuthenticationConverter converter = new ReactiveJwtAuthenticationConverter();
    converter.setJwtGrantedAuthoritiesConverter(
        new ReactiveJwtGrantedAuthoritiesConverterAdapter(authoritiesConverter)
    );
    converter.setPrincipalClaimName("userId");
    return converter;
  }
}
