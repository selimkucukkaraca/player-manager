package com.producter.playermanager.dto.converter;

import com.producter.playermanager.dto.PlayerDto;
import com.producter.playermanager.dto.request.CreatePlayerRequest;
import com.producter.playermanager.model.Player;
import com.producter.playermanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    private final TeamConverter teamConverter;

    public PlayerConverter(TeamConverter teamConverter) {
        this.teamConverter = teamConverter;
    }

    public PlayerDto convertDto(Player from) {
        return new PlayerDto(
                from.getName(),
                from.getLastName(),
                teamConverter.convertDto(from.getTeam()),
                from.getPlayerPosition(),
                from.getPlayerId(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public Player toEntity(CreatePlayerRequest request, Team team) {
        return new Player(
                request.getName(),
                request.getLastName(),
                team,
                request.getPlayerPosition()
        );
    }
}