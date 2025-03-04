package com.backend.ott.repository.token;

import com.backend.ott.entity.token.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepository extends JpaRepository<TokenEntity, String>, TokenCustomRepository {
}
