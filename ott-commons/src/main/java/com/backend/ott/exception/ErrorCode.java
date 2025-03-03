package com.backend.ott.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DEFAULT_ERROR("OTT0000", "에러가 발생했습니다."),

    USER_DOES_NOT_EXIST("OTT2000", "사용자가 존재하지 않습니다."),
    USER_ALREADY_EXIST("OTT2001", "사용자가 이미 존재합니다."),
    ;

    private final String code;
    private final String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "[" + code + "] " + desc;
    }
}
