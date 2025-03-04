package com.backend.ott.token;

public interface UpdateTokenPort {
    void updateToken(String userId, String accessToken, String refreshToken);
}
