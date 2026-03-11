package com.ipl.premier_league.service;

import com.ipl.premier_league.model.Player;
import com.ipl.premier_league.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepo;

    //This method save/register One new Player into the database
    @Override
    public Player savePlayer(Player player) {
        log.info("Saving new player: {}", player.getName());
        playerRepo.save(player);
        log.info("Player saved successfully: {}", player.getName());
        return player;
    }

    //This Method will return all the Player Details
    @Override
    public List<Player> getAllPlayers() {
        log.info("Fetching all players");
        List<Player> players = playerRepo.findAll();
        log.info("Total players fetched: {}", players.size());
        return players;
    }

    //This Method will return all the Player Details based on the Team Name
    @Override
    public List<Player> getPlayersByTeam(String teamName) {
        log.info("Fetching players for team: {}", teamName);
        List<Player> players = playerRepo.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
        log.info("Players found for team {} : {}", teamName, players.size());
        return players;
    }

    //This method gives All the player details who have same type of name
    @Override
    public List<Player> getAllPlayersByName(String searchName) {
        log.info("Searching players by name containing: {}", searchName);
        List<Player> players = playerRepo.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchName.toLowerCase()))
                .collect(Collectors.toList());
        log.info("Players found with name {} : {}", searchName, players.size());
        return players;
    }

    //This method gives all the player details based on the role
    @Override
    public List<Player> getAllPlayersByRole(String searchRole) {
        log.info("Searching players by role: {}", searchRole);
        List<Player> players = playerRepo.findAll().stream()
                .filter(player -> player.getRole().toLowerCase().contains(searchRole.toLowerCase()))
                .collect(Collectors.toList());
        log.info("Players found with role {} : {}", searchRole, players.size());
        return players;
    }

    //This method gives all the Player details from a specific Nation
    @Override
    public List<Player> getAllPlayerByNation(String searchNation) {
        log.info("Searching players by nation: {}", searchNation);
        List<Player> players = playerRepo.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchNation.toLowerCase()))
                .collect(Collectors.toList());
        log.info("Players found from nation {} : {}", searchNation, players.size());
        return players;
    }

    //This Method gives all players details based on the team name and role
    @Override
    public List<Player> getAllPlayerByTeamAndRole(String teamName, String role) {
        log.info("Searching players with team {} and role {}", teamName, role);
        List<Player> players = playerRepo.findAll().stream()
                .filter(player -> player.getTeam().equals(teamName) && player.getRole().equals(role))
                .collect(Collectors.toList());
        log.info("Players found with team {} and role {} : {}", teamName, role, players.size());
        return players;
    }

    //This Method is used to update the details of an existing player
    @Override
    public Player updatePlayer(Player player) {
        log.info("Updating player with name: {}", player.getName());

        Optional<Player> optional = playerRepo.findByName(player.getName());

        if (optional.isPresent()){
            Player existingPlayer = optional.get();
            log.info("Player found. Updating details for {}", player.getName());

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

            playerRepo.save(existingPlayer);

            log.info("Player updated successfully: {}", player.getName());
            return existingPlayer;
        }

        log.warn("Player not found with name: {}", player.getName());
        return null;
    }

    //This method will delete one player based on his id
    @Override
    public void deletePlayerById(String id) {
        log.info("Deleting player with id: {}", id);
        playerRepo.deleteById(id);
        log.info("Player deleted with id: {}", id);
    }

}