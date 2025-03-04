package com.backend.ott.entity.token;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTokenEntity is a Querydsl query type for TokenEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTokenEntity extends EntityPathBase<TokenEntity> {

    private static final long serialVersionUID = -1480580958L;

    public static final QTokenEntity tokenEntity = new QTokenEntity("tokenEntity");

    public final StringPath accessToken = createString("accessToken");

    public final DateTimePath<java.time.LocalDateTime> accessTokenExpiresAt = createDateTime("accessTokenExpiresAt", java.time.LocalDateTime.class);

    public final StringPath refreshToken = createString("refreshToken");

    public final DateTimePath<java.time.LocalDateTime> refreshTokenExpiresAt = createDateTime("refreshTokenExpiresAt", java.time.LocalDateTime.class);

    public final StringPath tokenId = createString("tokenId");

    public final StringPath userId = createString("userId");

    public QTokenEntity(String variable) {
        super(TokenEntity.class, forVariable(variable));
    }

    public QTokenEntity(Path<? extends TokenEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTokenEntity(PathMetadata metadata) {
        super(TokenEntity.class, metadata);
    }

}

