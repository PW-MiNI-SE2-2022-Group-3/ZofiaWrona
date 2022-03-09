package com.kata.software.calculator;
import com.kata.software.common.AbstractJunitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StringCalculatorTest extends AbstractJunitTest
{
    @Autowired
    public StringCalculator stringCalculator;

    @Test
    void calculateForEmptyStringReturnsZero()
    {
        final int expectedResult = 15;
        final int retrievedResult = stringCalculator.calculate("");

        Assertions.assertEquals(expectedResult, retrievedResult);
    }

    @Test
    void calculateForStringNumberEqualsNumber()
    {
        final int expectedResult = 5;
        final int retrievedResult = stringCalculator.calculate("5");

        Assertions.assertEquals(expectedResult, retrievedResult);
    }

    @Test
    void calculateForStringWithTwoNumbersAndCommaEqualSum()
    {
        final int expectedResult = 10;
        final int retrievedResult = stringCalculator.calculate("3,7");

        Assertions.assertEquals(expectedResult, retrievedResult);
    }

    @Test
    void calculateForStringWithTwoNumbersAndNewLineEqualSum()
    {
        final int expectedResult = 12;
        final int retrievedResult = stringCalculator.calculate("8\n4");

        Assertions.assertEquals(expectedResult, retrievedResult);
    }

    @Test
    void calculateForStringWithTwoThreeNumbersEqualSum()
    {
        final int expectedResult = 15;
        final int retrievedResult = stringCalculator.calculate("8\n4,3");

        Assertions.assertEquals(expectedResult, retrievedResult);
    }

    @Test
    void calculateForStringWithNegativeNumberThrowsException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringCalculator.calculate("-10"));
    }

    @Test
    void calculateForStringWithNumbersAbove1000BeingIgnored()
    {
        final int expectedResult = 15;
        final int retrievedResult = stringCalculator.calculate("8\n1001,4,3");

        Assertions.assertEquals(expectedResult, retrievedResult);
    }


}
