package com.producter.playermanager.dto.request;

import com.producter.playermanager.model.PlayerPosition;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePlayerRequest {
    private String name;
    private String lastName;
    private String teamName;
    private PlayerPosition playerPosition;
}