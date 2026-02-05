package com.ipl.premier_league.repository;

import com.ipl.premier_league.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, String> {
    public void deleteByName(String name);

    public Optional<Player> findByName(String name);
}
