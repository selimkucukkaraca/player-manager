package com.producter.playermanager.service;

import com.producter.playermanager.TestUtil;
import com.producter.playermanager.dto.converter.PlayerConverter;
import com.producter.playermanager.model.Player;
import com.producter.playermanager.repository.PlayerRepository;
import com.producter.playermanager.util.LogUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerServiceTest extends TestUtil {

    private PlayerRepository playerRepository;
    private PlayerConverter playerConverter;
    private TeamService teamService;
    private LogUtil logUtil;
    private PlayerService playerService;

    @BeforeEach
    public void setUp(){
        playerRepository = mock(PlayerRepository.class);
        playerConverter = mock(PlayerConverter.class);
        teamService = mock(TeamService.class);
        logUtil = mock(LogUtil.class);
        playerService = new PlayerService(playerRepository,playerConverter,teamService,logUtil);
    }

    @Test
    void createPlayer_itShouldReturnPlayerDto(){}

    @Test
    void getAllPlayers_itShouldReturnPlayerDtoList(){}


    @Test
    void delete(){
        Player player = getPlayerList().get(0);
        String playerId = "test";

        when(playerRepository.findPlayerByPlayerId(playerId)).thenReturn(Optional.ofNullable(player));

        playerService.deletePlayer(playerId);

        assert player != null;
        verify(playerRepository).delete(player);
    }

    @Test
    void getPlayerByPlayerId_itShouldReturnPlayer(){
        Player player = getPlayerList().get(0);
        String playerId = "test";

        when(playerRepository.findPlayerByPlayerId(playerId)).thenReturn(Optional.ofNullable(player));

        Player response = playerService.getPlayerByPlayerId(playerId);

        assertEquals(player,response);
        verify(playerRepository).findPlayerByPlayerId(playerId);
    }
}