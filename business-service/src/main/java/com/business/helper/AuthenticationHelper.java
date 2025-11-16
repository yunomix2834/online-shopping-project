package com.business.helper;

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
        return a.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
    }
}
