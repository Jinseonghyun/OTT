package com.backend.ott.token;

public interface SearchTokenPort {
    TokenPortResponse findByUserId(String userId);
}
