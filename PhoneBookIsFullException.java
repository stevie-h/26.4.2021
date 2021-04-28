package com.example;


//ex6

public class PhoneBookIsFullException extends Exception
{
    public PhoneBookIsFullException(String message)
    {
        super(message);
    }
}
