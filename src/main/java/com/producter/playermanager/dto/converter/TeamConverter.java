package com.producter.playermanager.dto.converter;

import com.producter.playermanager.dto.TeamDto;
import com.producter.playermanager.dto.request.CreateTeamRequest;
import com.producter.playermanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {

    public TeamDto convertDto(Team from){
        return new TeamDto(from.getName());
    }

    public Team toEntity(CreateTeamRequest request){
        return new Team(request.getName());
    }
}