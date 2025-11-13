package com.core.helper;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class AuthenticationHelper {
    public String getMyUserId() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a == null || a.getName() == null) throw new AppException(ErrorCode.UNAUTHENTICATED);
        return a.getName();
    }

    public Set<String> getMyRoles() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a == null) throw new AppException(ErrorCode.UNAUTHENTICATED);
        Set<String> roles = a.getAuthorities()
                  .stream()
                  .map(GrantedAuthority::getAuthority)
                  .collect(Collectors.toSet());
        return roles;
    }

    public void requireAdmin() {
        if (!getMyRoles().contains("ROLE_ADMIN") && !getMyRoles().contains("ADMIN")) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
    }
}
