package com.producter.playermanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @ManyToOne
    private Team team;
    @Enumerated(EnumType.STRING)
    private PlayerPosition playerPosition;
    private String playerId = UUID.randomUUID().toString();

    public Player(String name, String lastName, Team team, PlayerPosition playerPosition) {
        this.name = name;
        this.lastName = lastName;
        this.team = team;
        this.playerPosition = playerPosition;
    }
}