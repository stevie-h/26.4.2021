package com.example;

//ex9

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

import java.lang.reflect.Field;


public class TripleCalculatorTest
{

    private int get_m_boomCount(TripleCalculator calculator)
    {
        try
        {
            int m_boomCount = 0;
            Field privateStringField = null;
            privateStringField = TripleCalculator.class.
                    getDeclaredField("m_boomCount");
            privateStringField.setAccessible(true);
            m_boomCount = (int) privateStringField.get(calculator);

            return m_boomCount;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return 0;
    }


    //checks if entered 0, returns 300
    @Test
    public void test_tripleCalculator_Mul0()
    {
        TripleCalculator calculator = new TripleCalculator();
        int number = 0;

        assertEquals(300, calculator.calc(number));
    }

    //checks if number that isn't 0 or divides by 7 is entered, returns the number tripled
    @Test
    public void test_tripleCalculator_Mul3()
    {
        TripleCalculator calculator = new TripleCalculator();
        int number = 11;

        assertEquals(number * 3, calculator.calc(number));
    }

    //checks if returns 7 if number is 7
    @Test
    public void test_tripleCalculator_boom7()
    {
        TripleCalculator calculator = new TripleCalculator();
        int number = 7;

        assertEquals(7, calculator.calc(number));
    }

    //checks if counts boom if number is 7
    @Test
    public void test_tripleCalculator_boomCount7()
    {
        TripleCalculator calculator = new TripleCalculator();

        calculator.calc(7);

        assertEquals(1, get_m_boomCount(calculator));
    }

    //checks if returns 7 if number divides by 7 (but not 7)
    @Test
    public void test_tripleCalculator_boomNot7()
    {
        TripleCalculator calculator = new TripleCalculator();

        int number = 14;

        assertEquals(7, calculator.calc(number));
    }

    //checks if counts boom if number divides by 7 (but not 7)
    @Test
    public void test_tripleCalculator_boomCountNot7()
    {
        TripleCalculator calculator = new TripleCalculator();

        calculator.calc(14);

        assertEquals(1, get_m_boomCount(calculator));
    }

    //checks if counts number of booms correctly when the two numbers entered divide by 7
    @Test
    public void test_tripleCalculator_countsBoom_both()
    {
        TripleCalculator calculator = new TripleCalculator();

        calculator.calc(7);
        calculator.calc(21);

        assertEquals(2, get_m_boomCount(calculator));
    }

    //checks if counts number of booms correctly when only one of two numbers entered divides by 7
    @Test
    public void test_tripleCalculator_countsBoom_onlyOne()
    {
        TripleCalculator calculator = new TripleCalculator();

        calculator.calc(7);
        calculator.calc(11);

        assertEquals(1, get_m_boomCount(calculator));
    }





}
