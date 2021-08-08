package com.practice.problem.solving.strings;

import org.junit.Assert;
import org.junit.Test;

public class BinaryStringAdditionTest {

    @Test
    public void testIsCorrectCapitalization(){
        BinaryStringAddition binaryStringAddition = new BinaryStringAddition();
        Assert.assertEquals("101",binaryStringAddition.getBinaryStringAddition("100","1"));
        Assert.assertEquals("100",binaryStringAddition.getBinaryStringAddition("11","1"));
        Assert.assertEquals("1",binaryStringAddition.getBinaryStringAddition("1","0"));
    }
}
