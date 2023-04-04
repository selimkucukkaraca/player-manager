package com.producter.playermanager.service;

import com.producter.playermanager.dto.PlayerDto;
import com.producter.playermanager.dto.converter.PlayerConverter;
import com.producter.playermanager.dto.request.CreatePlayerRequest;
import com.producter.playermanager.exception.NotFoundException;
import com.producter.playermanager.exception.PlayerCountLimitExceededException;
import com.producter.playermanager.model.Log;
import com.producter.playermanager.model.LogType;
import com.producter.playermanager.model.Player;
import com.producter.playermanager.model.Team;
import com.producter.playermanager.repository.PlayerRepository;
import com.producter.playermanager.util.LogUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.producter.playermanager.util.Constants.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerConverter playerConverter;
    private final TeamService teamService;
    private final LogUtil logUtil;


    public PlayerDto createPlayer(CreatePlayerRequest request){
        var team = teamService.getTeamByName(request.getTeamName());

        if (checkTeamPlayerCount(team)){
            throw new PlayerCountLimitExceededException("12 players reached");
        }

        var saved = playerConverter.toEntity(request,team);
        playerRepository.save(saved);
        logUtil.save(new Log("Player successfully add : " + saved.getName() ,LogType.CREATE));

        return playerConverter.convertDto(saved);
    }

    public List<PlayerDto> getAllPlayers(int page, int size){
        Pageable pageable = PageRequest.of(page,size);

        logUtil.save(new Log("All players successfully called : " ,LogType.LIST));
        return playerRepository.findAll(pageable)
                .stream()
                .map(playerConverter::convertDto)
                .toList();
    }

    public void deletePlayer(String playerId){
        var player = getPlayerByPlayerId(playerId);
        playerRepository.delete(player);
        logUtil.save(new Log("Player successfully deleted : " + playerId, LogType.DELETE));

    }

    protected Player getPlayerByPlayerId(String playerId){
        return playerRepository.findPlayerByPlayerId(playerId)
                .orElseThrow(() -> new NotFoundException("Player not fount, playerId: " + playerId));

    }

    private List<Player> getPlayerByTeamName(String teamName){
        return playerRepository.findAll()
                .stream()
                .filter(player -> player.getTeam().getName().equals(teamName))
                .toList();
    }

    private boolean checkTeamPlayerCount(Team team){
        return getPlayerByTeamName(team.getName()).size() >= TEAM_PLAYER_LIMIT;
    }

}
