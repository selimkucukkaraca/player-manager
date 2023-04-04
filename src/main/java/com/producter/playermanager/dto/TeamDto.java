package com.producter.playermanager.dto;

import java.time.OffsetDateTime;

public record TeamDto(
        String name,
        OffsetDateTime createDate,
        OffsetDateTime updateDate) {
}