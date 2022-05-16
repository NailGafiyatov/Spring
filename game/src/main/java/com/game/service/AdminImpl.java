package com.game.service;

import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminImpl implements Admin {
    static List<Player> playerList = new ArrayList<>();
    static Player player;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdminImpl admin = new AdminImpl();
        System.out.println(admin.getPlayersList().toString());
        System.out.println(admin.getPlayersCount());
        System.out.println(admin.getPlayerById(1L));
        System.out.println(admin.updatePlayerById(1L));
        admin.deletePlayerById(1L);
        System.out.println(playerList.toString());
    }


    public List<Player> getPlayersList() {
        String userName = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/rpg";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try(Connection connection = DriverManager.getConnection(connectionURL, userName, password) ;
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from player");

            System.out.println("We're connected to the database");

            Long n = 1L;
            while (resultSet.next()) {
                Long id = n;
                String name = resultSet.getString("name");
                String title = resultSet.getString("title");
                Race race = Race.valueOf(resultSet.getString("race"));
                Profession profession = Profession.valueOf(resultSet.getString("profession"));
                Integer experience = resultSet.getInt("experience");
//                Integer level = resultSet.getInt("level");
//                Integer untilNextLevel = resultSet.getInt("untilNextLevel");
                Date birthday = resultSet.getDate("birthday");
                Boolean banned = resultSet.getBoolean("banned");

                Player player = new Player(id, name, title, race, profession, experience, birthday, banned);
                playerList.add(player);
                n++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playerList;
    }

    public int getPlayersCount() {

        return playerList.size();
    }

    public Player createPlayer(Long id, String name, String title, Race race, Profession profession, Integer experience, Date birthday, Boolean banned) {
        if (banned == null) {banned = false;}
        Player newPlayer = new Player(id, name, title, race, profession, experience, birthday, banned);
        playerList.add(newPlayer);
        return newPlayer;
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerList.get(Math.toIntExact(id) - 1);
    }

    @Override
    public Player updatePlayerById(Long id) {
        return playerList.get(Math.toIntExact(id) - 1);
    }

    @Override
    public void deletePlayerById(Long id) {
        playerList.remove(playerList.get(Math.toIntExact(id) - 1));
    }
}
