package com.backend.ott.repository.token;


import com.backend.ott.entity.token.TokenEntity;

import java.util.Optional;

public interface TokenCustomRepository {
    Optional<TokenEntity> findByUserId(String userId);
}
