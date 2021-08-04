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
}
