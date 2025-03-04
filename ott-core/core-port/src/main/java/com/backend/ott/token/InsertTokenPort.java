package com.backend.ott.token;

public interface InsertTokenPort {
    TokenPortResponse create(String userId, String accessToken, String refreshToken);
}
