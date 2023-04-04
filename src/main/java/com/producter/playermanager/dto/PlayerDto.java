package com.producter.playermanager.dto;

import com.producter.playermanager.model.PlayerPosition;

public record PlayerDto(
        String name,
        String lastName,
        TeamDto team,
        PlayerPosition playerPosition) {
}