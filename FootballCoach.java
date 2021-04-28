package com.example;

//ex8

import java.util.ArrayList;

public class FootballCoach
{
    private ArrayList<String> m_activePlayers = new ArrayList<>();
    private ArrayList<String> m_benchPlayers = new ArrayList<>();
    private String m_playersFormation;


    public void sendPlayerToBench(String player) throws InvalidPlayerException, InvalidCoachAction
    {
        if (player == null)
        {
            throw new InvalidPlayerException("Player input is invalid!");
        }
        if (!m_activePlayers.contains(player))
        {
            throw new InvalidCoachAction(String.format("Invalid input - %s is not in the field", player));
        }
        m_activePlayers.remove(player);
        m_benchPlayers.add(0, player);
    }

    public void sendPlayerToField(String player) throws InvalidPlayerException, InvalidCoachAction
    {
        if (player == null)
        {
            throw new InvalidPlayerException("Player input is invalid!");
        }
        if (!m_benchPlayers.contains(player))
        {
            throw new InvalidCoachAction(String.format("Invalid input - %s is not on the bench", player));
        }
        m_benchPlayers.remove(player);
        m_activePlayers.add(0, player);
    }

    public void changePlayersFormation(String playersFormation) throws NotEnoughPlayersException
    {
        if (m_activePlayers.size() < 11)
        {
            throw new NotEnoughPlayersException("There are not enough field players to create formation!");
        }
        m_playersFormation = playersFormation;
    }




}