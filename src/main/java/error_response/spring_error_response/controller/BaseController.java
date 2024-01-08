package error_response.spring_error_response.controller;

import error_response.spring_error_response.common.ApiResponse;
import error_response.spring_error_response.exception.CustomException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

abstract public class BaseController {

    public <T> ApiResponse<T> makeResponse(T result) {
        return makeResponse(Collections.singletonList(result));
    }

    public <T> ApiResponse<T> makeResponse(List<T> results) {
        return new ApiResponse<>(results);
    }

    @ExceptionHandler(CustomException.class)
    public ApiResponse<Integer> customExceptionHandler(HttpServletResponse response, CustomException exception) {
        response.setStatus(exception.getErrorCode().getHttpStatus().value());
        return new ApiResponse(exception.getErrorCode().getCode(), exception.getMessage(), exception.getValue());
    }
}
