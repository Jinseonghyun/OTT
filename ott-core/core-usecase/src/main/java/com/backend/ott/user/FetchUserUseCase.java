package com.backend.ott.user;

import com.backend.ott.user.command.UserResponse;

public interface FetchUserUseCase {
    UserResponse findUserByEmail(String email);
}
