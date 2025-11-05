package com.core.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

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
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Autowired
    private CustomJwtDecoder customJwtDecoder;


    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .headers(headers -> headers.frameOptions(
                        frame -> frame.sameOrigin()))
                .authorizeHttpRequests(request -> request
                        .requestMatchers(PUBLIC_ENDPOINTS)
                        .permitAll()
                        .anyRequest()
                        .authenticated());

        httpSecurity.oauth2ResourceServer(
                oauth2 -> oauth2.jwt(jwtConfigurer -> jwtConfigurer
                                .decoder(customJwtDecoder)
                                .jwtAuthenticationConverter(
                                        jwtAuthenticationConverter()))
                        .authenticationEntryPoint(
                                new JwtAuthenticationEntryPoint()));
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(List.of(
                FRONTEND_ENDPOINT
        ));

        configuration.setAllowedMethods(
                List.of(GET_METHOD, POST_METHOD, PUT_METHOD, DELETE_METHOD,
                        PATCH_METHOD, OPTIONS_METHOD));

        configuration.setAllowedHeaders(
                List.of(AUTHORIZATION_HEADER, CONTENT_TYPE_HEADER,
                        ACCEPT_HEADER));

        // Cho phép gửi credentials (cookie, header, v.v.)
        configuration.setAllowCredentials(true);

        // Expose header "Authorization"
        configuration.setExposedHeaders(List.of(AUTHORIZATION_HEADER));

        // Thời gian cache preflight request
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        // Áp dụng cấu hình cho tất cả các endpoint
        source.registerCorsConfiguration(URL_PATTERN_ALL, configuration);
        return source;
    }


    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter authConverter =
                new JwtGrantedAuthoritiesConverter();
        authConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(authConverter);

        converter.setPrincipalClaimName("userId");

        return converter;
    }
}
