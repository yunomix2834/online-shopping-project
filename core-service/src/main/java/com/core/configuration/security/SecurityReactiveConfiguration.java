package com.core.configuration.security;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtGrantedAuthoritiesConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import static org.common.constant.SecurityConstants.ACCEPT_HEADER;
import static org.common.constant.SecurityConstants.AUTHORIZATION_HEADER;
import static org.common.constant.SecurityConstants.CONTENT_TYPE_HEADER;
import static org.common.constant.SecurityConstants.FRONTEND_ENDPOINT;
import static org.common.constant.SecurityConstants.PUBLIC_ENDPOINTS;
import static org.common.constant.SecurityConstants.URL_PATTERN_ALL;
import static org.springdoc.core.utils.Constants.DELETE_METHOD;
import static org.springdoc.core.utils.Constants.GET_METHOD;
import static org.springdoc.core.utils.Constants.OPTIONS_METHOD;
import static org.springdoc.core.utils.Constants.PATCH_METHOD;
import static org.springdoc.core.utils.Constants.POST_METHOD;
import static org.springdoc.core.utils.Constants.PUT_METHOD;

@Configuration
@RequiredArgsConstructor
public class SecurityReactiveConfiguration {

    private final GrpcReactiveJwtDecoder jwtDecoder;
    private final JwtReactiveEntryPoint entryPoint;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(
            ServerHttpSecurity http) {
        return http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)

            .cors(cors -> cors.configurationSource(corsConfigurationSource()))

            .headers(headers -> headers.frameOptions(frame -> frame
                .mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN)))

            .authorizeExchange(ex -> ex
                .pathMatchers(PUBLIC_ENDPOINTS)
                .permitAll()
                .anyExchange()
                .authenticated())
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

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();

    configuration.setAllowedOriginPatterns(List.of(FRONTEND_ENDPOINT));

    configuration.setAllowedMethods(List.of(
        GET_METHOD, POST_METHOD, PUT_METHOD,
        DELETE_METHOD, PATCH_METHOD, OPTIONS_METHOD
    ));

    configuration.setAllowedHeaders(List.of(
        AUTHORIZATION_HEADER,
        CONTENT_TYPE_HEADER,
        ACCEPT_HEADER
    ));

    configuration.setAllowCredentials(true);
    configuration.setExposedHeaders(List.of(AUTHORIZATION_HEADER));
    configuration.setMaxAge(3600L);

    UrlBasedCorsConfigurationSource source =
        new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration(URL_PATTERN_ALL, configuration);
    return source;
  }
}
