package com.backend.ott.controller;

import com.backend.ott.exception.ErrorCode;

public record OttApiResponse<T> (
        boolean success,
        String code,
        String message,
        T data
) {
    public static final String CODE_SUCCEED = "SUCCEED";

    public static <T> OttApiResponse<T> ok(T data) {
        return new OttApiResponse<>(true, CODE_SUCCEED, null, data);
    }

    public static <T> OttApiResponse<T> fail(ErrorCode errorCode, String message) {
        return new OttApiResponse<>(false, errorCode.getCode(), message, null);
    }
}
