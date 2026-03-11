package com.ipl.premier_league.controller;

import com.ipl.premier_league.model.Player;
import com.ipl.premier_league.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/players")
@Slf4j
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<Player> getPlayers(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String team,
                                   @RequestParam(required = false) String role,
                                   @RequestParam(required = false) String nation) throws Exception{
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
    public ResponseEntity<?> addOnePlayer(@Valid @RequestBody Player player) throws Exception{
        log.info("Request hit in controller for player addition in db.");
        return new ResponseEntity<>(playerService.savePlayer(player), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updatePlayer(@RequestBody Player player) throws Exception{
        log.info("Request hit in controller for player updation in db.");
        Player updatedPlayer = playerService.updatePlayer(player);
        if(updatedPlayer != null){
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Id/{id}")
    public ResponseEntity<?> deletePlayerByHisId(@PathVariable String id) throws Exception{
        log.info("Request hit in controller for player deletion in db.");
        playerService.deletePlayerById(id);
        return new ResponseEntity<>("Player got deleted Successfully", HttpStatus.OK);
    }
}
