package com.business.configuration.security;

import net.devh.boot.grpc.server.security.authentication.BearerAuthenticationReader;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;

@Configuration
public class GrpcServerSecurityConfig {
    @Bean
    public GrpcAuthenticationReader grpcAuthenticationReader() {
        return new BearerAuthenticationReader(token ->
                new BearerTokenAuthenticationToken(token));
    }
}
