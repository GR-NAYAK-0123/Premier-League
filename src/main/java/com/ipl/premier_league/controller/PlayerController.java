package com.ipl.premier_league.controller;

import com.ipl.premier_league.model.Player;
import com.ipl.premier_league.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<Player> getPlayers(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String team,
                                   @RequestParam(required = false) String role,
                                   @RequestParam(required = false) String nation){
        if (team != null && role != null){
            return playerService.getAllPlayerByTeamAndRole(team, role);
        } else if (name != null) {
            return playerService.getAllPlayersByName(name);
        } else if (role != null) {
            return playerService.getAllPlayersByRole(role);
        } else if (nation != null) {
            return playerService.getAllPlayerByNation(nation);
        } else if (team != null) {
            return playerService.getPlayersByTeam(team);
        } else {
            return playerService.getAllPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<?> addOnePlayer(@RequestBody Player player){
        return new ResponseEntity<>(playerService.savePlayer(player), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updatePlayer(@RequestBody Player player){
        Player updatedPlayer = playerService.updatePlayer(player);
        if(updatedPlayer != null){
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<?> deletePlayerByName(@PathVariable String playerName){
        playerService.deleteOnePlayerByName(playerName);
        return new ResponseEntity<>("Player got deleted Successfully", HttpStatus.OK);
    }
}
