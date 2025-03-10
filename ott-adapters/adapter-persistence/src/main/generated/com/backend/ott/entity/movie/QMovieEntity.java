package com.backend.ott.entity.movie;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMovieEntity is a Querydsl query type for MovieEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovieEntity extends EntityPathBase<MovieEntity> {

    private static final long serialVersionUID = -2071917744L;

    public static final QMovieEntity movieEntity = new QMovieEntity("movieEntity");

    public final com.backend.ott.audit.QMutableBaseEntity _super = new com.backend.ott.audit.QMutableBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath genre = createString("genre");

    public final BooleanPath isAdult = createBoolean("isAdult");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath movieId = createString("movieId");

    public final StringPath movieName = createString("movieName");

    public final StringPath overview = createString("overview");

    public final StringPath releaseAt = createString("releaseAt");

    public QMovieEntity(String variable) {
        super(MovieEntity.class, forVariable(variable));
    }

    public QMovieEntity(Path<? extends MovieEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovieEntity(PathMetadata metadata) {
        super(MovieEntity.class, metadata);
    }

}

