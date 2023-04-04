package com.producter.playermanager.dto;

import java.time.LocalDateTime;

public record TeamDto(
        String name,
        LocalDateTime createDate,
        LocalDateTime updateDate) {
}