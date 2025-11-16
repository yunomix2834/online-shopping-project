package org.common.security;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Aspect
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RequireAdminAspect {

  @Around(
      "@annotation(org.common.security.RequireAdmin) || " +
          "@within(org.common.security.RequireAdmin)"
  )
  public Object checkAdmin(ProceedingJoinPoint pjp) throws Throwable {
    Authentication authentication = getAuthentication();

    Set<String> roles = authentication.getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toSet());

    boolean isAdmin = roles.contains("ROLE_ADMIN") || roles.contains("ADMIN");

    if (!isAdmin) {
      log.warn("User [{}] không có quyền ADMIN, roles={}",
          authentication.getName(), roles);
      throw new AppException(ErrorCode.UNAUTHORIZED);
    }

    return pjp.proceed();
  }

  private Authentication getAuthentication() {
    // Ưu tiên SecurityContextHolder (blocking)
    Authentication a = Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .orElse(null);

    if (a != null && a.isAuthenticated()) {
      return a;
    }

    // Nếu không có, fallback sang ReactiveSecurityContextHolder (WebFlux)
    return ReactiveSecurityContextHolder.getContext()
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated)
        .switchIfEmpty(
            Mono.error(new AppException(ErrorCode.UNAUTHENTICATED))
        )
        .block();
  }
}
