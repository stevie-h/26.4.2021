package com.example;

//ex8

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;

import java.lang.reflect.Field;

public class FootballCoachTest
{

    private ArrayList<String> get_activePlayersList(FootballCoach fc)
    {
        try
        {
            ArrayList<String> fieldValue = null;
            Field privateStringField = null;
            privateStringField = FootballCoach.class.getDeclaredField("m_activePlayers");
            privateStringField.setAccessible(true);
            fieldValue = (ArrayList<String>)privateStringField.get(fc);

            return fieldValue;
        }
        catch (NoSuchFieldException ex)
        {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> get_benchPlayersList(FootballCoach fc)
    {
        try
        {
            ArrayList<String> fieldValue = null;
            Field privateStringField = null;
            privateStringField = FootballCoach.class.getDeclaredField("m_benchPlayers");
            privateStringField.setAccessible(true);
            fieldValue = (ArrayList<String>)privateStringField.get(fc);

            return fieldValue;
        }
        catch (NoSuchFieldException ex)
        {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    private String get_playersFormation(FootballCoach fc)
    {
        try
        {
            String fieldValue = null;
            Field privateStringField = null;
            privateStringField = FootballCoach.class.getDeclaredField("m_playersFormation");
            privateStringField.setAccessible(true);
            fieldValue = (String)privateStringField.get(fc);

            return fieldValue;
        }
        catch (NoSuchFieldException ex)
        {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }


    //send player to field from bench OK
    @Test
    public void test_FootballCoach_sendPlayerToField_pos() throws InvalidCoachAction, InvalidPlayerException
    {
        FootballCoach fc = new FootballCoach();
        ArrayList <String> benchList = get_benchPlayersList(fc);
        ArrayList <String> activeList = get_activePlayersList(fc);

        benchList.add("James");
        fc.sendPlayerToField("James");

        assertEquals(1, activeList.size());
        assertEquals(0, benchList.size());
        assertEquals("James", activeList.get(0));
    }

    //send player to field from bench fails - invalid player info
    @Test (expected = InvalidPlayerException.class)
    public void test_FootballCoach_sendPlayerToField_neg1() throws InvalidCoachAction, InvalidPlayerException
    {
        FootballCoach fc = new FootballCoach();
        fc.sendPlayerToField(null);
    }

    //send player to field from bench fails - no player on bench
    @Test (expected = InvalidCoachAction.class)
    public void test_FootballCoach_sendPlayerToField_neg2() throws InvalidCoachAction, InvalidPlayerException
    {
        FootballCoach fc = new FootballCoach();
        fc.sendPlayerToField("James");
    }

    //send player to bench from field OK
    @Test
    public void test_FootballCoach_sendPlayerToBench_pos() throws InvalidCoachAction, InvalidPlayerException
    {
        FootballCoach fc = new FootballCoach();
        ArrayList <String> activeList = get_activePlayersList(fc);
        ArrayList <String> benchList = get_benchPlayersList(fc);

        activeList.add("Dean");
        fc.sendPlayerToBench("Dean");

        assertEquals(1, benchList.size());
        assertEquals(0, activeList.size());
        assertEquals("Dean", benchList.get(0));
    }

    //send player to bench from field fails - invalid player info
    @Test (expected = InvalidPlayerException.class)
    public void test_FootballCoach_sendPlayerToBench_neg1() throws InvalidCoachAction, InvalidPlayerException
    {
        FootballCoach fc = new FootballCoach();
        fc.sendPlayerToBench(null);
    }

    //send player to bench from field fails - no player in field
    @Test (expected = InvalidCoachAction.class)
    public void test_FootballCoach_sendPlayerToBench_neg2() throws InvalidCoachAction, InvalidPlayerException
    {
        FootballCoach fc = new FootballCoach();
        fc.sendPlayerToBench("Dean");
    }

    //change formation OK
    @Test
    public void test_FootballCoach_changePlayersFormation_pos() throws NotEnoughPlayersException
    {
        FootballCoach fc = new FootballCoach();
        ArrayList <String> activeList = get_activePlayersList(fc);

        for (int i = 0; i < 11; i++)
        {
            activeList.add("James");
        }

        fc.changePlayersFormation("4-4-2");

        assertEquals("4-4-2", get_playersFormation(fc));
    }

    //change formation fails - not enough players on field to form play
    @Test (expected = NotEnoughPlayersException.class)
    public void test_FootballCoach_changePlayersFormation_neg() throws NotEnoughPlayersException
    {
        FootballCoach fc = new FootballCoach();
        ArrayList<String> activeList = get_activePlayersList(fc);

        for (int i = 0; i < 10; i++)
        {
            activeList.add("James");
        }

        fc.changePlayersFormation("4-4-2");
    }




}
