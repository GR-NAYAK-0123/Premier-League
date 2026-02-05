package com.ipl.premier_league.service;

import com.ipl.premier_league.model.Player;
import com.ipl.premier_league.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepo;

    //This method save/register One new Player into the database
    @Override
    public Player savePlayer(Player player) {
        playerRepo.save(player);
        return player;
    }

    //This Method will return all the Player Details
    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    //This Method will return all the Player Details based on the Team Name
    @Override
    public List<Player> getPlayersByTeam(String teamName) {
        return playerRepo.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    //This method gives All the player details who have same type of name
    @Override
    public List<Player> getAllPlayersByName(String searchName) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchName.toLowerCase()))
                .collect(Collectors.toList());
    }

    //This method gives all the player details based on the role
    @Override
    public List<Player> getAllPlayersByRole(String searchRole) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getRole().toLowerCase().contains(searchRole.toLowerCase()))
                .collect(Collectors.toList());
    }

    //This method gives all the Player details from a specific Nation
    @Override
    public List<Player> getAllPlayerByNation(String searchNation) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchNation.toLowerCase()))
                .collect(Collectors.toList());
    }

    //This Method gives all players details based on the team name and role
    @Override
    public List<Player> getAllPlayerByTeamAndRole(String teamName, String role) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getTeam().equals(teamName) && player.getRole().equals(role))
                .collect(Collectors.toList());
    }


}
