package com.producter.playermanager.repository;

import com.producter.playermanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findPlayerByPlayerId(String playerId);
}