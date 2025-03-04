package com.backend.ott.controller.user;

import com.backend.ott.controller.OttApiResponse;
import com.backend.ott.controller.user.request.UserLoginRequest;
import com.backend.ott.controller.user.request.UserRegisterRequest;
import com.backend.ott.security.OttAuthUser;
import com.backend.ott.token.FetchTokenUseCase;
import com.backend.ott.token.UpdateTokenUseCase;
import com.backend.ott.user.FetchUserUseCase;
import com.backend.ott.user.RegisterUserUseCase;
import com.backend.ott.user.command.UserRegistrationCommand;
import com.backend.ott.user.response.UserRegistrationResponse;
import com.backend.ott.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
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
    private final FetchUserUseCase fetchUserUseCase;
    private final UpdateTokenUseCase updateTokenUseCase;

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
        UserResponse kakaoUser = fetchUserUseCase.findKakaoUser(accessTokenFromKakao);

        // 소셜 사용자가 이미 존재하는지 확인을 해야 하고
        UserResponse byProviderId = fetchUserUseCase.findByProviderId(kakaoUser.getProviderId());

        // 만약 존재하지 않으면, 회원가입을 하는 부분
        if (ObjectUtils.isEmpty(byProviderId)) {
            registerUserUseCase.registerSocialUser(
                    kakaoUser.getUsername(),
                    kakaoUser.getProvider(),
                    kakaoUser.getProviderId()
            );
        }

        // 토큰을 발급해서 반환
        return OttApiResponse.ok(updateTokenUseCase.upsertToken(kakaoUser.getProviderId()));
    }
}
