package error_response.spring_error_response.exception;

import error_response.spring_error_response.common.ErrorCode;
import org.springframework.core.codec.CodecException;

public class CustomException extends RuntimeException{

    private final ErrorCode errorCode;

    private String message;

    private int value = 0;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public CustomException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }


    public CustomException(ErrorCode errorCode, String message, int grade) {
        this.errorCode = errorCode;
        this.message = message;
        this.value = grade;
    }
}
