package com.example;

//ex6

import java.util.ArrayList;

public class Cellphone
{

    public ArrayList<String> phonebook = new ArrayList<>(10);

    public void addPhoneNumberToList(String phoneNumber) throws InvalidNumberException, PhoneBookIsFullException
    {
        if (phoneNumber == null)
        {
            throw new InvalidNumberException("Number is invalid!");
        }
        if (phonebook.size() < 10)
        {
            phonebook.add(phoneNumber);
        }
        else
        {
            throw new PhoneBookIsFullException("The phonebookif full with the maximum 10 numbers!");
        }
    }

    public void callingNumber(String phoneNumber) throws InvalidNumberException
    {
        if (phoneNumber == null)
        {
            throw new InvalidNumberException("Number is invalid!");
        }
        System.out.println("Calling... " + phoneNumber);
    }


}
