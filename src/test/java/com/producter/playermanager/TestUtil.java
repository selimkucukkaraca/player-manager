package com.producter.playermanager;

import com.producter.playermanager.dto.PlayerDto;
import com.producter.playermanager.dto.TeamDto;
import com.producter.playermanager.dto.request.CreatePlayerRequest;
import com.producter.playermanager.dto.request.CreateTeamRequest;
import com.producter.playermanager.model.Player;
import com.producter.playermanager.model.Team;

import java.util.List;

public class TestUtil {

    public CreateTeamRequest getCreateTeamRequest(){
        CreateTeamRequest request = new CreateTeamRequest();
        request.setName("test");
        return request;
    }

    public List<TeamDto> getTeamDtoList(){
        return List.of(new TeamDto("test",null,null));
    }

    public List<Team> getTeamList(){
        return List.of(new Team(1L,"test"));
    }


    public CreatePlayerRequest getCreatePlayerRequest(){
        return new CreatePlayerRequest("test","test","test",null);
    }

    public List<PlayerDto> getPlayerDtoList(){
        return List.of(new PlayerDto("test","test",null,null,"test",null,null));
    }

    public List<Player> getPlayerList(){
        return List.of(new Player(1L,"test","test",null,null,"test"));
    }
}