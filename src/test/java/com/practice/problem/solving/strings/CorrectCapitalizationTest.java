package com.practice.problem.solving.strings;

import org.junit.Assert;
import org.junit.Test;

public class CorrectCapitalizationTest {

    @Test
    public void testIsCorrectCapitalization(){
        CorrectCapitalization correctCapitalization = new CorrectCapitalization();
        Assert.assertTrue(correctCapitalization.isCorrectCapitalization("USA"));
        Assert.assertTrue(correctCapitalization.isCorrectCapitalization("Calvin"));
        Assert.assertFalse(correctCapitalization.isCorrectCapitalization("compUter"));
        Assert.assertTrue(correctCapitalization.isCorrectCapitalization("coding"));
    }
}
