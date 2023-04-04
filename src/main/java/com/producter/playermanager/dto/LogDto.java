package com.producter.playermanager.dto;

import com.producter.playermanager.model.LogType;

import java.time.LocalDateTime;

public record LogDto(
        String description,
        LogType logType,
        LocalDateTime createDate,
        LocalDateTime updateDate) {
}