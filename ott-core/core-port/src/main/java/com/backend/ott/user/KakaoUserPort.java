package com.backend.ott.user;

public interface KakaoUserPort {
    UserPortResponse findUserFromKakao(String accessToken);
}
