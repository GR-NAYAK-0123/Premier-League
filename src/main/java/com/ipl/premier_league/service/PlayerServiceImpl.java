package com.ipl.premier_league.service;

import com.ipl.premier_league.model.Player;
import com.ipl.premier_league.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    //This Method is used to update the details of an existing player
    @Override
    public Player updatePlayer(Player player) {
        Optional<Player> optional = playerRepo.findByName(player.getName());
        if (optional.isPresent()){
            Player existingPlayer = optional.get();
            existingPlayer.setNation(player.getNation());
            existingPlayer.setTeam(player.getTeam());
            existingPlayer.setRole(player.getRole());
            existingPlayer.setAge(player.getAge());
            existingPlayer.setActive(player.getActive());
            existingPlayer.setJerseyNumber(player.getJerseyNumber());
            existingPlayer.setCenturies(player.getCenturies());
            existingPlayer.setFifties(player.getFifties());
            existingPlayer.setWickets(player.getWickets());
            existingPlayer.setBestScore(player.getBestScore());
            //Save the player
            playerRepo.save(existingPlayer);
            return existingPlayer;
        }
        return null;
    }

    //This Method is used to delete One Player details from the database
    @Transactional
    @Override
    public void deleteOnePlayer(Player player) {
        playerRepo.deleteByName(player.getName());
    }

    //This method will delete One player by his name
    @Override
    public void deleteOnePlayerByName(String name) {
        playerRepo.deleteByName(name);
    }

}
