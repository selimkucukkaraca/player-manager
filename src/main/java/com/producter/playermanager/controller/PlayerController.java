package com.producter.playermanager.controller;

import com.producter.playermanager.dto.PlayerDto;
import com.producter.playermanager.dto.request.CreatePlayerRequest;
import com.producter.playermanager.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @MutationMapping
    PlayerDto createPlayer(@Argument CreatePlayerRequest request){
        return playerService.createPlayer(request);
    }

    @MutationMapping
    Boolean deletePlayer(@Argument String playerId){
        playerService.deletePlayer(playerId);
        return true;
    }

    @QueryMapping
    List<PlayerDto> getAllPlayers(@Argument int page, @Argument int size){
        return playerService.getAllPlayers(page, size);
    }
}