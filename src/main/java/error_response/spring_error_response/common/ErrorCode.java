package error_response.spring_error_response.common;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    OK(2000, HttpStatus.OK, "OK"),
    BAD_REQUEST(4000, HttpStatus.BAD_REQUEST, "잘못된 요청입니다.")
    ;


    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    private final int code;
    private final HttpStatus httpStatus;

    private final String message;

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
