package com.example;

//ex8

public class NotEnoughPlayersException extends Exception
{
    public NotEnoughPlayersException(String message)
    {
        super(message);
    }
}
