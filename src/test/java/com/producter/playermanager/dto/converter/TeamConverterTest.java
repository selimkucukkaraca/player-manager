package com.producter.playermanager.dto.converter;

import com.producter.playermanager.TestUtil;
import com.producter.playermanager.dto.TeamDto;
import com.producter.playermanager.dto.request.CreateTeamRequest;
import com.producter.playermanager.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TeamConverterTest extends TestUtil {

    private TeamConverter teamConverter;

    @BeforeEach
    public void setUp(){
        teamConverter = mock(TeamConverter.class);
    }

    @Test
     void convertToDto_itShouldReturnTeamDto(){
        Team team = getTeamList().get(0);
        TeamDto teamDto = getTeamDtoList().get(0);

        when(teamConverter.convertDto(team)).thenReturn(teamDto);

        TeamDto response = teamConverter.convertDto(team);

        assertEquals(teamDto,response);
    }

    @Test
    void toEntity_itShouldReturnTeam(){
        CreateTeamRequest request = getCreateTeamRequest();
        Team team = getTeamList().get(0);

        when(teamConverter.toEntity(request)).thenReturn(team);

        Team response = teamConverter.toEntity(request);

        assertEquals(team,response);
    }

}