package com.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayserverApplication {

    static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

//    @Bean
//    public RouteLocator yunomixRouteConfig(
//            RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/demo/demo2/**")
//                        .filters(
//                                f -> f.rewritePath("/demo/demo2/(?<segment>.*)",
//                                                "/${segment}")
//                                        .addResponseHeader("X-Response-Time",
//                                                LocalDateTime.now().toString())
//                                        .circuitBreaker(
//                                                config -> config.setName(
//                                                                "demo2CircuitBreaker")
//                                                        .setFallbackUri(
//                                                                "forward:/contactSupport")))
//                        .uri("lb://DEMO2"))
//                .route(p -> p
//                        .path("/demo/demo1/**")
//                        .filters(
//                                f -> f.rewritePath("/demo/demo1/(?<segment>.*)",
//                                                "/${segment}")
//                                        .addResponseHeader("X-Response-Time",
//                                                LocalDateTime.now().toString())
//                                        .circuitBreaker(
//                                                config -> config.setName(
//                                                                "demo1CircuitBreaker")
//                                                        .setFallbackUri(
//                                                                "forward:/contactSupport")))
//                        .uri("lb://DEMO1"))
//                .build();
//    }
//
//    @Bean
//    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
//        return factory -> factory.configureDefault(
//                id -> new Resilience4JConfigBuilder(id)
//                        .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//                        .timeLimiterConfig(
//                                TimeLimiterConfig.custom()
//                                        .timeoutDuration(Duration.ofSeconds(4))
//                                        .build()).build());
//    }
//
//    @Bean
//    public RedisRateLimiter redisRateLimiter() {
//        return new RedisRateLimiter(1, 1, 1);
//    }
//
//    @Bean
//    KeyResolver userKeyResolver() {
//        return exchange -> Mono.justOrEmpty(
//                        exchange.getRequest().getHeaders().getFirst("user"))
//                .defaultIfEmpty("Anonymous");
//    }
}
