package com.ipl.premier_league.repository;

import com.ipl.premier_league.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {

}
