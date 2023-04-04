package com.producter.playermanager.dto;

import com.producter.playermanager.model.PlayerPosition;

import java.time.LocalDateTime;

public record PlayerDto(
        String name,
        String lastName,
        TeamDto team,
        PlayerPosition playerPosition,
        String playerId,
        LocalDateTime createDate,
        LocalDateTime updateDate) {
}