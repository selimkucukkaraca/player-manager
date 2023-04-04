package com.producter.playermanager.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import java.time.OffsetDateTime;


@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @CreationTimestamp
    private OffsetDateTime createDate;
    private OffsetDateTime updateDate;

}