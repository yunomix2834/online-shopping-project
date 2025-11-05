package org.common.constant;

public final class SecurityConstants {
    // Headers
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String CONTENT_TYPE_HEADER  = "Content-Type";
    public static final String ACCEPT_HEADER        = "Accept";

    // CORS mặc định
    public static final String FRONTEND_ENDPOINT = "http://localhost:4200";

    // Public endpoints chuẩn
    public static final String[] PUBLIC_ENDPOINTS = {
            "/health", "/actuator/**", "/auth/**", "/h2-console/**"
    };

    // Methods
    public static final String GET="GET", POST="POST", PUT="PUT", DELETE="DELETE", PATCH="PATCH", OPTIONS="OPTIONS";

    // Path
    public static final String URL_PATTERN_ALL = "/**";

    private SecurityConstants(){}
}