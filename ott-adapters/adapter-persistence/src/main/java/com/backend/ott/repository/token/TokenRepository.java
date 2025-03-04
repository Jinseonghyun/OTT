package com.backend.ott.repository.token;

import com.backend.ott.token.InsertTokenPort;
import com.backend.ott.token.SearchTokenPort;
import com.backend.ott.token.TokenPortResponse;
import com.backend.ott.token.UpdateTokenPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class TokenRepository implements SearchTokenPort, InsertTokenPort, UpdateTokenPort {

    private final TokenJpaRepository tokenJpaRepository;


    @Override
    @Transactional
    public TokenPortResponse create(String userId, String accessToken, String refreshToken) {
        return null;
    }

    @Override
    @Transactional
    public TokenPortResponse findByUserId(String userId) {
        return null;
    }

    @Override
    @Transactional
    public void updateToken(String userId, String accessToken, String refreshToken) {

    }
}
