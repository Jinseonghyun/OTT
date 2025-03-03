package com.backend.ott.advice;

import com.backend.ott.controller.OttApiResponse;
import com.backend.ott.exception.ErrorCode;
import com.backend.ott.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(UserException.class)
    protected OttApiResponse<?> handleUserException(UserException e) {
        log.error("error={}", e.getErrorCode(), e);
        return OttApiResponse.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    protected OttApiResponse<?> handleRuntimeException(RuntimeException e) {
        log.error("error={}", e.getMessage(), e);
        return OttApiResponse.fail(ErrorCode.DEFAULT_ERROR, e.getMessage());
    }
}
