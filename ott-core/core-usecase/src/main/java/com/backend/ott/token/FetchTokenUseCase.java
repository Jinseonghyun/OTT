package com.backend.ott.token;

import com.backend.ott.user.response.UserResponse;

public interface FetchTokenUseCase {
    Boolean validateToken(String accessToken);

    String getTokenFromKakao(String code);

    UserResponse findUserByAccessToken(String accessToken);
}
