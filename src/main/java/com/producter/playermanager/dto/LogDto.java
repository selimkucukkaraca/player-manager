package com.producter.playermanager.dto;

import com.producter.playermanager.model.LogType;

import java.time.OffsetDateTime;

public record LogDto(
        String description,
        LogType logType,
        OffsetDateTime createDate,
        OffsetDateTime updateDate) {
}