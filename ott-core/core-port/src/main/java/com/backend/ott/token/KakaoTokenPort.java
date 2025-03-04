package com.backend.ott.token;

public interface KakaoTokenPort {
    String getAccessTokenByCode(String code);
}
