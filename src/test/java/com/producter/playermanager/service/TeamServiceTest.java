package com.producter.playermanager.service;

import com.producter.playermanager.TestUtil;
import com.producter.playermanager.dto.TeamDto;
import com.producter.playermanager.dto.converter.TeamConverter;
import com.producter.playermanager.dto.request.CreateTeamRequest;
import com.producter.playermanager.model.Team;
import com.producter.playermanager.repository.TeamRepository;
import com.producter.playermanager.util.LogUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeamServiceTest extends TestUtil {

    private TeamRepository teamRepository;
    private TeamConverter teamConverter;
    private LogUtil logUtil;
    private TeamService teamService;

    @BeforeEach
    public void setUp(){
        teamRepository = mock(TeamRepository.class);
        teamConverter = mock(TeamConverter.class);
        logUtil = mock(LogUtil.class);
        teamService = new TeamService(teamRepository,teamConverter,logUtil);
    }

    @Test
     void createTeam_itShouldReturnTeamDto(){
        CreateTeamRequest request = getCreateTeamRequest();
        Team team = getTeamList().get(0);
        TeamDto teamDto = getTeamDtoList().get(0);

        when(teamConverter.toEntity(request)).thenReturn(team);
        when(teamRepository.save(team)).thenReturn(team);
        when(teamConverter.convertDto(team)).thenReturn(teamDto);
        when(teamRepository.existsTeamByName("test")).thenReturn(false);

        TeamDto response = teamService.createTeam(request);

        assertEquals(teamDto,response);
        verify(teamConverter).toEntity(request);
        verify(teamRepository).save(team);
        verify(teamConverter).convertDto(team);
        verify(teamRepository).existsTeamByName("test");
    }

    @Test
    void getAllTeams_itShouldReturnTeamDtoList(){}

    @Test
     void delete(){
        Team team = getTeamList().get(0);
        String teamName = "test";

        when(teamRepository.findTeamByName(teamName)).thenReturn(Optional.ofNullable(team));

        teamService.deleteTeam(teamName);

        assert team != null;
        verify(teamRepository).delete(team);
    }

    @Test
    void getTeamByName_itShouldReturnTeam(){
        Team team = getTeamList().get(0);
        String name = "test";

        when(teamRepository.findTeamByName(name)).thenReturn(Optional.ofNullable(team));

        Team response = teamService.getTeamByName(name);

        assertEquals(team,response);
        verify(teamRepository).findTeamByName(name);

    }
}