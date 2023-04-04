package com.producter.playermanager.service;

import com.producter.playermanager.dto.PlayerDto;
import com.producter.playermanager.dto.converter.PlayerConverter;
import com.producter.playermanager.dto.request.CreatePlayerRequest;
import com.producter.playermanager.exception.NotFoundException;
import com.producter.playermanager.model.Player;
import com.producter.playermanager.model.Team;
import com.producter.playermanager.repository.PlayerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerConverter playerConverter;
    private final TeamService teamService;


    public PlayerService(PlayerRepository playerRepository, PlayerConverter playerConverter, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.playerConverter = playerConverter;
        this.teamService = teamService;
    }

    public PlayerDto save(CreatePlayerRequest request){
        Team team = teamService.getTeamByName(request.getName());
        var saved = playerConverter.toEntity(request,team);
        // kisi sayisini kontrol et
        playerRepository.save(saved);
        return playerConverter.convertDto(saved);
    }

    public List<PlayerDto> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);

        return playerRepository.findAll(pageable)
                .stream()
                .map(playerConverter::convertDto)
                .collect(Collectors.toList());
    }

    public void delete(String playerId){
        var player = getPlayerByPlayerId(playerId);
        playerRepository.delete(player);
    }

    protected Player getPlayerByPlayerId(String playerId){
        return playerRepository.findPlayerByPlayerId(playerId)
                .orElseThrow(() -> new NotFoundException("Player not fount, playerId: " + playerId));

    }

}
