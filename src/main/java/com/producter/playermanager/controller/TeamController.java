package com.producter.playermanager.controller;

import com.producter.playermanager.dto.TeamDto;
import com.producter.playermanager.dto.request.CreateTeamRequest;
import com.producter.playermanager.service.TeamService;
import lombok.RequiredArgsConstructor;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @MutationMapping
    public TeamDto createTeam(@Argument CreateTeamRequest request){
        return teamService.createTeam(request);
    }

    @MutationMapping
    public Boolean deleteTeam(@Argument String name){
        teamService.deleteTeam(name);
        return true;
    }

    @QueryMapping
    public List<TeamDto> getAllTeams(@Argument int page, @Argument int size){
        return teamService.getAllTeams(page, size);
    }
}