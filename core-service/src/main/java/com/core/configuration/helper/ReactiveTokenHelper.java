package com.core.configuration.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import reactor.core.publisher.Mono;

public final class ReactiveTokenHelper {
    private ReactiveTokenHelper() {}

    public static Mono<String> currentBearerToken() {
        return ReactiveSecurityContextHolder.getContext()
                .flatMap(ctx -> Mono.justOrEmpty(ctx.getAuthentication()))
                .filter(Authentication::isAuthenticated)
                .ofType(AbstractOAuth2TokenAuthenticationToken.class)
                .map(b -> b.getToken().getTokenValue())
                .filter(t -> t != null && !t.isBlank());
    }

}
