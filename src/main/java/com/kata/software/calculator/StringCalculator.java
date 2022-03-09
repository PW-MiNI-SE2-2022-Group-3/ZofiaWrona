package com.kata.software.calculator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

@Service
public class StringCalculator
{
    public int calculate(final String inputString)
    {
        final Set<String> delimeterSet = Set.of(",","\n");

        if(inputString.equals(""))
            return 0;

        final String delimeterRegex = "[" + StringUtils.join(delimeterSet, null) + "]";

        IntStream obtainedStrings = Arrays.stream(inputString.split(delimeterRegex)).mapToInt(el -> {
            try
            {
                final int elNum = Integer.parseInt(el);
                if(elNum < 0)
                {
                    throw new IllegalArgumentException();
                }
                return elNum > 1000 ? 0 : elNum;
            }
            catch (final NumberFormatException e)
            {
                System.out.println("The element is not a number");
                throw new IllegalArgumentException();
            }
        });

        return obtainedStrings.sum();

    }
}
