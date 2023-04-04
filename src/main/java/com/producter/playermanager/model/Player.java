package com.producter.playermanager.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;
    @Enumerated(EnumType.STRING)
    private PlayerPosition playerPosition;

    public Player(String name, String lastName, Team team, PlayerPosition playerPosition) {
        this.name = name;
        this.lastName = lastName;
        this.team = team;
        this.playerPosition = playerPosition;
    }
}