package com.business.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;

@Configuration
public class GrpcJwtAuthManagerConfig {

    @Bean
    public JwtAuthenticationConverter grpcJwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        return jwtAuthenticationConverter;
    }

    @Bean
    public AuthenticationManager grpcAuthenticationManager(
            JwtDecoder jwtDecoder,
            JwtAuthenticationConverter grpcJwtAuthenticationConverter) {

        JwtAuthenticationProvider provider = new JwtAuthenticationProvider(jwtDecoder);
        provider.setJwtAuthenticationConverter(grpcJwtAuthenticationConverter);
        return new ProviderManager(provider);
    }
}