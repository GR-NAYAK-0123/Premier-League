package com.ipl.premier_league.controller;

import com.ipl.premier_league.model.Player;
import com.ipl.premier_league.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayers();
    }

}
