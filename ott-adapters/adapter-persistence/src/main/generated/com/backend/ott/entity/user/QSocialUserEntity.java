package com.backend.ott.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSocialUserEntity is a Querydsl query type for SocialUserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSocialUserEntity extends EntityPathBase<SocialUserEntity> {

    private static final long serialVersionUID = 891750201L;

    public static final QSocialUserEntity socialUserEntity = new QSocialUserEntity("socialUserEntity");

    public final com.backend.ott.audit.QMutableBaseEntity _super = new com.backend.ott.audit.QMutableBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath provider = createString("provider");

    public final StringPath providerId = createString("providerId");

    public final StringPath socialUserId = createString("socialUserId");

    public final StringPath username = createString("username");

    public QSocialUserEntity(String variable) {
        super(SocialUserEntity.class, forVariable(variable));
    }

    public QSocialUserEntity(Path<? extends SocialUserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSocialUserEntity(PathMetadata metadata) {
        super(SocialUserEntity.class, metadata);
    }

}

