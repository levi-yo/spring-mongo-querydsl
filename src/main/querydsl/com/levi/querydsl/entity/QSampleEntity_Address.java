package com.levi.querydsl.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleEntity_Address is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSampleEntity_Address extends BeanPath<SampleEntity.Address> {

    private static final long serialVersionUID = 1302283898L;

    public static final QSampleEntity_Address address = new QSampleEntity_Address("address");

    public final StringPath dong = createString("dong");

    public final StringPath gu = createString("gu");

    public final StringPath si = createString("si");

    public QSampleEntity_Address(String variable) {
        super(SampleEntity.Address.class, forVariable(variable));
    }

    public QSampleEntity_Address(Path<? extends SampleEntity.Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleEntity_Address(PathMetadata metadata) {
        super(SampleEntity.Address.class, metadata);
    }

}

