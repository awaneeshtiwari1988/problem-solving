package com.practice.problem.solving.strings;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void testReverseStringByBuilder(){
        ReverseString reverseString = new ReverseString();
        Assert.assertEquals("taC",reverseString.reverseStringByStringBuilder("Cat"));
        Assert.assertEquals("etyB yliaD ehT",reverseString.reverseStringByStringBuilder("The Daily Byte"));
        Assert.assertEquals("civic",reverseString.reverseStringByStringBuilder("civic"));
    }

    @Test
    public void testReverseString(){
        ReverseString reverseString = new ReverseString();
        Assert.assertEquals("taC",reverseString.reverseStringByTraversingChars("Cat"));
        Assert.assertEquals("etyB yliaD ehT",reverseString.reverseStringByTraversingChars("The Daily Byte"));
        Assert.assertEquals("civic",reverseString.reverseStringByTraversingChars("civic"));
    }

    @Test
    public void testReverseString_1(){
        ReverseString reverseString = new ReverseString();
        Assert.assertEquals(String.valueOf("taC".toCharArray()),String.valueOf(reverseString.reverseStringByTwoWayTraversal("Cat".toCharArray())));
        Assert.assertEquals(String.valueOf("etyB yliaD ehT".toCharArray()),String.valueOf(reverseString.reverseStringByTwoWayTraversal("The Daily Byte".toCharArray())));
        Assert.assertEquals(String.valueOf("civic".toCharArray()),String.valueOf(reverseString.reverseStringByTwoWayTraversal("civic".toCharArray())));
    }

    @Test
    public void testReverseString_2(){
        ReverseString reverseString = new ReverseString();
        Assert.assertEquals(String.valueOf("taC".toCharArray()),String.valueOf(reverseString.reverseStringByStacks("Cat".toCharArray())));
        Assert.assertEquals(String.valueOf("etyB yliaD ehT".toCharArray()),String.valueOf(reverseString.reverseStringByStacks("The Daily Byte".toCharArray())));
        Assert.assertEquals(String.valueOf("civic".toCharArray()),String.valueOf(reverseString.reverseStringByStacks("civic".toCharArray())));
    }
}
