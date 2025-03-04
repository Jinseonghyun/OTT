package com.backend.ott.user;

import com.backend.ott.user.command.UserRegistrationCommand;
import com.backend.ott.user.response.UserRegistrationResponse;

public interface RegisterUserUseCase {
    UserRegistrationResponse register(UserRegistrationCommand command);
    UserRegistrationResponse registerSocialUser(String username, String provider, String providerId);
}
