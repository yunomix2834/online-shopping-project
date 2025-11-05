package com.gatewayserver.configuration.security;

import com.common.grpc.AuthServiceGrpc;
import com.common.grpc.IntrospectRequest;
import com.common.grpc.IntrospectResponse;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GrpcReactiveJwtDecoder implements ReactiveJwtDecoder {

    @GrpcClient("core")
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    @Override
    public Mono<Jwt> decode(String token) throws JwtException {
        return Mono.fromCallable(() -> {
                    IntrospectResponse resp = authServiceBlockingStub.introspect(
                            IntrospectRequest.newBuilder().setToken(token).build());
                    if (!resp.getValid()) throw new JwtException("INVALID_TOKEN");

                    SignedJWT sjwt;
                    try {
                        sjwt = SignedJWT.parse(token);
                    } catch (ParseException e) {
                        throw new JwtException("JWT_PARSE_ERROR", e);
                    }

                    Map<String, Object> headers =
                            new HashMap<>(sjwt.getHeader().toJSONObject());

                    Map<String, Object> claims =
                            new HashMap<>(sjwt.getJWTClaimsSet().getClaims());

                    Date iat = sjwt.getJWTClaimsSet().getIssueTime();
                    Date exp = sjwt.getJWTClaimsSet().getExpirationTime();

                    Instant issuedAt = (iat == null) ? null : iat.toInstant();
                    Instant expiresAt = (exp == null) ? null : exp.toInstant();

                    return new Jwt(token, issuedAt, expiresAt, headers, claims);
                })
                .onErrorMap(e -> (e instanceof JwtException)
                        ? e
                        : new JwtException("AUTH_INTROSPECT_UNAVAILABLE", e));
    }
}
