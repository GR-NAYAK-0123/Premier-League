package com.ipl.premier_league.service;

import com.ipl.premier_league.model.Player;

import java.util.List;

public interface PlayerService {

    public Player savePlayer(Player player);
    public List<Player> getAllPlayers();
    public List<Player> getPlayersByTeam(String teamName);
    public List<Player> getAllPlayersByName(String searchName);
    public List<Player> getAllPlayersByRole(String searchRole);
    public List<Player> getAllPlayerByNation(String searchNation);
    public List<Player> getAllPlayerByTeamAndRole(String teamName, String role);
}
