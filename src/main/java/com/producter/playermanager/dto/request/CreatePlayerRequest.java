package com.producter.playermanager.dto.request;

import com.producter.playermanager.model.PlayerPosition;
import lombok.Data;

@Data
public class CreatePlayerRequest {
    private String name;
    private String lastName;
    private String teamName;
    private PlayerPosition playerPosition;
}