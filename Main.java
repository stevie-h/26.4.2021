package com.example;

//exercise 9

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {

        //ex1
        /*
        a. The Exception class is the base that exceptions inherit from in Java.
        b. A runtime exception is an exception that occurs at the time of execution of the code.
        c. Example for an exception inhering from RuntimeException: NullPointerException
*/

        //ex2
        /*
        a. A checked exception is an exception that is checked at compile time.
        b. An unchecked exception is an exception which  is not checked at compile time but
           at the time of execution of the code.
        c. RuntimeException is unchecked.
*/

        //ex3
        /*
        Finally is a statement or block which will be executed after a try block, regardless of the result
        of that code (exception thrown and handled with catch, thrown and not handled, not thrown).
*/

        //ex4
        countChar(null); //would throw NullPointerException

        //ex5
        /*
        A custom exception can be tailored to the needs of the programme or product,
        which would not already be defined within Java. This can include non-standard events or
        specific messages when the exception is thrown.
*/

        //ex7
        //a. We can access private (or any) members in a class using reflection.
        //b.
        Person p = new Person("Name7");
        String myName = getPersonName(p);
        System.out.println(myName);



    }

    static String getPersonName(Person p)
    {
        try
        {
            String m_name = null;
            Field privateStringField = null;
            privateStringField = Person.class.
                    getDeclaredField("m_name");
            privateStringField.setAccessible(true);
            m_name = (String) privateStringField.get(p);

            return m_name;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    static int countChar(String str)
    {
        try
        {
            return str.length();
        }
        catch (NullPointerException ex)
        {
            System.out.println("Exception thrown: " + ex);
        }
        return 0;
    }



}
