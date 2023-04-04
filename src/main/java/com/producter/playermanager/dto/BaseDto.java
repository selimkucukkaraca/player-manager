package com.producter.playermanager.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseDto {

    @CreationTimestamp
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}