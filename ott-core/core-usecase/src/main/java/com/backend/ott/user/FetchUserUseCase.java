package com.backend.ott.user;

import com.backend.ott.user.response.UserResponse;

public interface FetchUserUseCase {
    UserResponse findUserByEmail(String email);
}
