package com.producter.playermanager.dto;

import com.producter.playermanager.model.PlayerPosition;

import java.time.OffsetDateTime;

public record PlayerDto(
        String name,
        String lastName,
        TeamDto team,
        PlayerPosition playerPosition,
        String playerId,
        OffsetDateTime createDate,
        OffsetDateTime updateDate) {
}