package com.game.service;

import com.game.entity.Player;
import com.game.entity.Profession;
import com.game.entity.Race;

import java.util.Date;
import java.util.List;

public interface Admin {
    public List<Player> getPlayersList();

    public int getPlayersCount();

    public Player createPlayer(Long id, String name, String title, Race race, Profession profession, Integer experience, Date birthday, Boolean banned);

    public Player getPlayerById(Long id);

    public Player updatePlayerById(Long id);

    public void deletePlayerById(Long id);
}
