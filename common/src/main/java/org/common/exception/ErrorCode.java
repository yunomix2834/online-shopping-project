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
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ErrorCode {
    // 500
    UNCATEGORIZED_EXCEPTION(999, INTERNAL_SERVER_STATUS, "Lỗi chưa phân loại", HttpStatus.INTERNAL_SERVER_ERROR),

    // 400
    VALIDATION_FAILED(400, BAD_REQUEST_STATUS, "Dữ liệu không hợp lệ!", org.springframework.http.HttpStatus.BAD_REQUEST),
    INVALID_OTP(400, BAD_REQUEST_STATUS, "OTP không hợp lệ!", BAD_REQUEST),
    OTP_EXPIRED(400, BAD_REQUEST_STATUS, "OTP đã hết hạn!", BAD_REQUEST),
    EMAIL_SEND_FAILED(4008003, BAD_REQUEST_STATUS, "Gửi email thất bại!", BAD_REQUEST),
    PARENT_CYCLE(400, BAD_REQUEST_STATUS, "Chu kỳ danh mục (parent) không hợp lệ", BAD_REQUEST),
    THUMBNAIL_ALREADY_SET(400, BAD_REQUEST_STATUS, "Đã có thumbnail cho thực thể này", BAD_REQUEST),

    // 401
    UNAUTHENTICATED(401, UNAUTHORIZED_STATUS, "Chưa xác thực!", HttpStatus.UNAUTHORIZED),
    INVALID_CREDENTIALS(401, UNAUTHORIZED_STATUS, "Thông tin đăng nhập không hợp lệ!", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN(401, UNAUTHORIZED_STATUS, "Token không hợp lệ!", HttpStatus.UNAUTHORIZED),
    TOKEN_REVOKED(401, UNAUTHORIZED_STATUS, "Token đã bị thu hồi!", HttpStatus.UNAUTHORIZED),

    // 403
    UNAUTHORIZED(403, FORBIDDEN_STATUS, "Bạn không có quyền truy cập!", HttpStatus.FORBIDDEN),

    // 404
    RESOURCE_NOT_FOUND(404, NOT_FOUND_STATUS, "Không tìm thấy tài nguyên", HttpStatus.NOT_FOUND),

    // 409
    RESOURCE_ALREADY_EXISTS(409, CONFLICT_STATUS, "Tài nguyên đã tồn tại!", HttpStatus.CONFLICT),

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
