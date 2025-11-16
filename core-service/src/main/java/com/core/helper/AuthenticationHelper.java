package com.core.helper;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import reactor.core.publisher.Mono;

@UtilityClass
@Slf4j
public class AuthenticationHelper {

  public String getMyUserId() {
    Authentication a = getAuthentication();
    return a.getName();
  }

  public Set<String> getMyRoles() {
    Authentication a = getAuthentication();
    return a.getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toSet());
  }

  private Authentication getAuthentication() {
    Authentication a = Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .orElse(null);

    if (a != null && a.isAuthenticated()) {
      return a;
    }

    return ReactiveSecurityContextHolder.getContext()
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated)
        .switchIfEmpty(Mono.error(new AppException(ErrorCode.UNAUTHENTICATED)))
        .block();
  }
}
