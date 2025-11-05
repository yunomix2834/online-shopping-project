package org.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import static org.common.constant.ErrorCodeConstant.BAD_REQUEST_STATUS;
import static org.common.constant.ErrorCodeConstant.CONFLICT_STATUS;
import static org.common.constant.ErrorCodeConstant.FORBIDDEN_STATUS;
import static org.common.constant.ErrorCodeConstant.INTERNAL_SERVER_STATUS;
import static org.common.constant.ErrorCodeConstant.NOT_FOUND_STATUS;
import static org.common.constant.ErrorCodeConstant.UNAUTHORIZED_STATUS;

@Getter
public enum ErrorCode {
    // 500
    UNCATEGORIZED_EXCEPTION(999, INTERNAL_SERVER_STATUS, "Lỗi chưa phân loại", HttpStatus.INTERNAL_SERVER_ERROR),

    // 400
    VALIDATION_FAILED(400, BAD_REQUEST_STATUS, "Dữ liệu không hợp lệ!", org.springframework.http.HttpStatus.BAD_REQUEST),

    // 401
    UNAUTHENTICATED(401, UNAUTHORIZED_STATUS, "Chưa xác thực!", HttpStatus.UNAUTHORIZED),
    INVALID_CREDENTIALS(401, UNAUTHORIZED_STATUS, "Thông tin đăng nhập không hợp lệ!", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN(401, UNAUTHORIZED_STATUS, "Token không hợp lệ!", HttpStatus.UNAUTHORIZED),
    TOKEN_REVOKED(401, UNAUTHORIZED_STATUS, "Token đã bị thu hồi!", HttpStatus.UNAUTHORIZED),

    // 403
    UNAUTHORIZED(403, FORBIDDEN_STATUS, "Bạn không có quyền truy cập!", HttpStatus.FORBIDDEN),

    // 404
    USER_NOT_FOUND(404, NOT_FOUND_STATUS, "Không tìm thấy user", HttpStatus.NOT_FOUND),
    ROLE_NOT_FOUND(404, NOT_FOUND_STATUS, "Không tìm thấy vai trò", HttpStatus.NOT_FOUND),
    ADDRESS_NOT_FOUND(404, NOT_FOUND_STATUS, "Không tìm thấy địa chỉ", HttpStatus.NOT_FOUND),

    // 409
    USER_ALREADY_EXISTS(409, CONFLICT_STATUS, "Người dùng đã tồn tại!", HttpStatus.CONFLICT),
    EMAIL_ALREADY_EXISTS(409, CONFLICT_STATUS, "Email đã tồn tại!", HttpStatus.CONFLICT),
    PASSWORD_ALREADY_EXISTS(409, CONFLICT_STATUS, "Mật khẩu đã tồn tại!", HttpStatus.CONFLICT),
    ROLE_ALREADY_EXISTS(409, CONFLICT_STATUS, "Vai trò đã tồn tại!", HttpStatus.CONFLICT),

    // 500
    FAILED_GENERATE_TOKEN(500, INTERNAL_SERVER_STATUS, "Lỗi tạo JWT token!", HttpStatus.INTERNAL_SERVER_ERROR),
    FAILED_VALIDATE_TOKEN(500, INTERNAL_SERVER_STATUS, "Lỗi xác thực token!", HttpStatus.INTERNAL_SERVER_ERROR),
    MAIL_DELIVERY_FAILED(500, INTERNAL_SERVER_STATUS, "Gửi email thất bại!", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String status;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String status, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }

    public int http() { return statusCode.value(); }
}