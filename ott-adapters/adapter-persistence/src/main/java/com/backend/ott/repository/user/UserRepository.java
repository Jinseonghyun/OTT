package com.backend.ott.repository.user;

import com.backend.ott.entity.user.SocialUserEntity;
import com.backend.ott.entity.user.UserEntity;
import com.backend.ott.repository.social.SocialUserJpaRepository;
import com.backend.ott.user.CreateUser;
import com.backend.ott.user.FetchUserPort;
import com.backend.ott.user.InsertUserPort;
import com.backend.ott.user.UserPortResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements FetchUserPort , InsertUserPort {

    private final UserJpaRepository userJpaRepository;
    private final SocialUserJpaRepository socialUserJpaRepository;

    @Override
    @Transactional
    public Optional<UserPortResponse> findByEmail(String email) {
        Optional<UserEntity> byEmail = userJpaRepository.findByEmail(email);
        return byEmail.map(userEntity -> UserPortResponse.builder()
                .userId(userEntity.getUserId())
                .password(userEntity.getPassword())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build());

    }

    @Override
    @Transactional
    public Optional<UserPortResponse> findByProviderId(String providerId) {
        Optional<SocialUserEntity> byProviderId = socialUserJpaRepository.findByProviderId(providerId);
        if (byProviderId.isEmpty()) {
            return Optional.empty();
        }

        SocialUserEntity socialUserEntity = byProviderId.get();

        return Optional.of(UserPortResponse.builder()
                .provider(socialUserEntity.getProvider())
                .providerId(socialUserEntity.getProviderId())
                .username(socialUserEntity.getUsername())
                .build());
    }

    @Override
    @Transactional
    public UserPortResponse create(CreateUser user) {
        UserEntity userEntity = new UserEntity(
                user.getUsername(),
                user.getEncryptedPassword(),
                user.getEmail(),
                user.getPhone());
        UserEntity save = userJpaRepository.save(userEntity);
        return UserPortResponse.builder()
                .userId(save.getUserId())
                .username(save.getUsername())
                .password(save.getPassword())
                .email(save.getEmail())
                .phone(save.getPhone())
                .build();
    }

    @Override
    @Transactional
    public UserPortResponse createSocialUser(String username, String provider, String providerId) {
        SocialUserEntity socialUserEntity = new SocialUserEntity(username, provider, providerId);
        socialUserJpaRepository.save(socialUserEntity);
        return UserPortResponse.builder()
                .provider(socialUserEntity.getProvider())
                .providerId(socialUserEntity.getProviderId())
                .username(socialUserEntity.getUsername())
                .build();
    }
}
