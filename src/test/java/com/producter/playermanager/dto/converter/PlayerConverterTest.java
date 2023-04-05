package com.producter.playermanager.dto.converter;

import com.producter.playermanager.TestUtil;
import com.producter.playermanager.dto.PlayerDto;
import com.producter.playermanager.dto.TeamDto;
import com.producter.playermanager.dto.request.CreatePlayerRequest;
import com.producter.playermanager.model.Player;
import com.producter.playermanager.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerConverterTest extends TestUtil {

    private TeamConverter teamConverter;
    private PlayerConverter playerConverter;

    @BeforeEach
    public void setUp(){
        teamConverter = mock(TeamConverter.class);
        playerConverter = mock(PlayerConverter.class);
    }

    @Test
    void convertToDto_itShouldReturnPlayerDto(){
        Player player = getPlayerList().get(0);
        PlayerDto playerDto = getPlayerDtoList().get(0);
        Team team = getTeamList().get(0);
        TeamDto teamDto = getTeamDtoList().get(0);

        when(playerConverter.convertDto(player)).thenReturn(playerDto);
        when(teamConverter.convertDto(team)).thenReturn(teamDto);

        PlayerDto response = playerConverter.convertDto(player);

        assertEquals(playerDto,response);

    }

    @Test
    void toEntity_itShouldReturnPlayer(){
        CreatePlayerRequest request = getCreatePlayerRequest();
        Team team = getTeamList().get(0);
        Player player = getPlayerList().get(0);

        when(playerConverter.toEntity(request,team)).thenReturn(player);

        Player response = playerConverter.toEntity(request,team);

        assertEquals(player,response);
    }

}