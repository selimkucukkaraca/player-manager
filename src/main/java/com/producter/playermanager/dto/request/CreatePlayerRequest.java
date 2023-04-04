package com.producter.playermanager.dto.request;

import com.producter.playermanager.model.PlayerPosition;
import com.producter.playermanager.model.Team;
import lombok.Data;

@Data
public class CreatePlayerRequest {

    private String name;
    private String lastName;
    private Team team;
    private PlayerPosition playerPosition;
}
