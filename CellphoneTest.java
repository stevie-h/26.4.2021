package com.example;


//ex6

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CellphoneTest
{

    //add number OK
    @Test
    public void testCellphone_addPhoneNumberToList_pos() throws InvalidNumberException, PhoneBookIsFullException
    {
        Cellphone cellphone = new Cellphone();
        cellphone.addPhoneNumberToList("1234567");

        assertEquals(1, cellphone.phonebook.size());
        assertEquals ("1234567", cellphone.phonebook.get(0));
    }

    //add number fails - invalid number
    @Test (expected = InvalidNumberException.class)
    public void testCellphone_addPhoneNumberToList_neg1() throws InvalidNumberException, PhoneBookIsFullException
    {
        Cellphone cellphone = new Cellphone();
        cellphone.addPhoneNumberToList(null);
    }

    //add number fails - phonebook is full
    @Test (expected = PhoneBookIsFullException.class)
    public void testCellphone_addPhoneNumberToList_neg2() throws InvalidNumberException, PhoneBookIsFullException
    {
        Cellphone cellphone = new Cellphone();
        for (int i = 0; i < 10; i++)
        {
            cellphone.addPhoneNumberToList("7654321");
        }
        cellphone.addPhoneNumberToList("2345678");
    }

    //calling number OK
    @Test
    public void testCellphone_callingNumber_pos() throws InvalidNumberException
    {
        Cellphone cellphone = new Cellphone();
        cellphone.callingNumber("1234567");
    }

    //calling number fails - invalid number
    @Test (expected = InvalidNumberException.class)
    public void testCellphone_callingNumber_neg() throws InvalidNumberException
    {
        Cellphone cellphone = new Cellphone();
        cellphone.callingNumber(null);
    }



}
