package com.levi.querydsl.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSampleEntity is a Querydsl query type for SampleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleEntity extends EntityPathBase<SampleEntity> {

    private static final long serialVersionUID = 1979635348L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSampleEntity sampleEntity = new QSampleEntity("sampleEntity");

    public final QSampleEntity_Address address;

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath id = createString("id");

    public final EnumPath<SampleEntity.Job> job = createEnum("job", SampleEntity.Job.class);

    public final StringPath name = createString("name");

    public QSampleEntity(String variable) {
        this(SampleEntity.class, forVariable(variable), INITS);
    }

    public QSampleEntity(Path<? extends SampleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSampleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSampleEntity(PathMetadata metadata, PathInits inits) {
        this(SampleEntity.class, metadata, inits);
    }

    public QSampleEntity(Class<? extends SampleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QSampleEntity_Address(forProperty("address")) : null;
    }

}

