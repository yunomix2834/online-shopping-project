package org.common.constant;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public final class ErrorCodeConstant {
    public static final String INTERNAL_SERVER_STATUS = HttpStatus.INTERNAL_SERVER_ERROR.toString();
    public static final String BAD_REQUEST_STATUS    = HttpStatus.BAD_REQUEST.toString();
    public static final String UNAUTHORIZED_STATUS   = HttpStatus.UNAUTHORIZED.toString();
    public static final String FORBIDDEN_STATUS      = HttpStatus.FORBIDDEN.toString();
    public static final String NOT_FOUND_STATUS      = HttpStatus.NOT_FOUND.toString();
    public static final String CONFLICT_STATUS       = HttpStatus.CONFLICT.toString();
}