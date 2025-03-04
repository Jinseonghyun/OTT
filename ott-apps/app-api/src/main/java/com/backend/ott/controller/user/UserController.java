package com.backend.ott.controller.user;

import com.backend.ott.controller.OttApiResponse;
import com.backend.ott.controller.user.request.UserLoginRequest;
import com.backend.ott.controller.user.request.UserRegisterRequest;
import com.backend.ott.security.OttAuthUser;
import com.backend.ott.token.FetchTokenUseCase;
import com.backend.ott.user.RegisterUserUseCase;
import com.backend.ott.user.command.UserRegistrationCommand;
import com.backend.ott.user.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final FetchTokenUseCase fetchTokenUseCase;

    @PostMapping("/api/v1/user/register")
    public OttApiResponse<UserRegistrationResponse> register(@RequestBody UserRegisterRequest request) {
        UserRegistrationResponse register = registerUserUseCase.register(
                UserRegistrationCommand.builder()
                        .email(request.getEmail())
                        .username(request.getUsername())
                        .encryptedPassword(request.getPassword())
                        .phone(request.getPhone())
                        .build()
        );

        return OttApiResponse.ok(register);
    }

    @PostMapping("/api/v1/user/login")
    public OttApiResponse<String> login(@RequestBody UserLoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(token);

        OttAuthUser principal = (OttAuthUser) authenticate.getPrincipal();

        return OttApiResponse.ok("access-token");
    }

    @PostMapping("/api/v1/user/callback")
    public OttApiResponse<String> kakaoCallback(@RequestBody Map<String, String> request) {
        String code = request.get("code");

        String accessTokenFromKakao = fetchTokenUseCase.getTokenFromKakao(code);

        return OttApiResponse.ok(null);
    }
}
