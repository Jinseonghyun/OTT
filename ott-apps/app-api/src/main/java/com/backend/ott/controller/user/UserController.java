package com.backend.ott.controller.user;

import com.backend.ott.controller.OttApiResponse;
import com.backend.ott.controller.user.request.UserRegisterRequest;
import com.backend.ott.user.RegisterUserUseCase;
import com.backend.ott.user.command.UserRegistrationCommand;
import com.backend.ott.user.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/api/v1/user/register")
    public OttApiResponse<UserRegistrationResponse> register(@RequestBody UserRegisterRequest request) {
        UserRegistrationResponse register = registerUserUseCase.register(
                UserRegistrationCommand.builder()
                        .email(request.getEmail())
                        .username(request.getUsername())
                        .encryptedPassword(passwordEncoder.encode(request.getPassword()))
                        .phone(request.getPhone())
                        .build()
        );

        return OttApiResponse.ok(register);
    }
}
