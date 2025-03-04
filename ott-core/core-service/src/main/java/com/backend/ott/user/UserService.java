package com.backend.ott.user;

import com.backend.ott.exception.UserException;
import com.backend.ott.user.command.UserRegistrationCommand;
import com.backend.ott.user.response.UserRegistrationResponse;
import com.backend.ott.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements FetchUserUseCase, RegisterUserUseCase {

    private final FetchUserPort fetchUserPort;
    private final InsertUserPort insertUserPort;
    private final KakaoUserPort kakaoUserPort;

    @Override
    public UserResponse findUserByEmail(String email) {
        Optional<UserPortResponse> byEmail = fetchUserPort.findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new UserException.UserDoesNotExistException();
        }

        UserPortResponse userPortResponse = byEmail.get();

        return UserResponse.builder()
                .userId(userPortResponse.getUserId())
                .email(userPortResponse.getEmail())
                .password(userPortResponse.getPassword())
                .phone(userPortResponse.getPhone())
                .role(userPortResponse.getRole())
                .username(userPortResponse.getUsername())
                .build();
    }

    @Override
    public UserResponse findByProviderId(String providerId) {
        return null;
    }

    @Override
    public UserResponse findKakaoUser(String accessToken) {
        UserPortResponse userFromKakao = kakaoUserPort.findUserFromKakao(accessToken);
        return UserResponse.builder()
                .provider(userFromKakao.getProvider())
                .providerId(userFromKakao.getProviderId())
                .username(userFromKakao.getUsername())
                .build();
    }

    @Override
    public UserRegistrationResponse register(UserRegistrationCommand command) {
        String email = command.getEmail();
        // 사용자 조회
        Optional<UserPortResponse> byEmail = fetchUserPort.findByEmail(email);

        // 만약 있으면?
        if (byEmail.isPresent()) {
            throw new UserException.UserAlreadyExistException();
        }

        // 회원가입 시도
        UserPortResponse response = insertUserPort.create(CreateUser.builder()
                        .username(command.getUsername())
                        .encryptedPassword(command.getEncryptedPassword())
                        .email(command.getEmail())
                        .phone(command.getPhone())
                        .build()
        );

        // UserRegistrationResponse 리턴
        return new UserRegistrationResponse(response.getUsername(), response.getEmail(), response.getPhone());
    }
}
