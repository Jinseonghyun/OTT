package com.backend.ott.token;

import com.backend.ott.token.response.TokenResponse;

public interface CreateTokenUseCase {
    TokenResponse createNewToken(String userId);
}
