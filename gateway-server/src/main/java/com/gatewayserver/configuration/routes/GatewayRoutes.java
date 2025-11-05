package com.gatewayserver.configuration.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutes {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                // /core/** -> lb://core/**
                .route("core",
                        r -> r.path("/core/**")
                                .filters(f -> f.rewritePath("^/core(?<segment>/.*)$", "${segment}"))
                                .uri("lb://core"))
                // /business/** -> lb://business/**
                .route("business",
                        r -> r.path("/business/**")
                                .filters(f -> f.rewritePath("^/business(?<segment>/.*)$", "${segment}"))
                                .uri("lb://business"))
                .build();
    }
}