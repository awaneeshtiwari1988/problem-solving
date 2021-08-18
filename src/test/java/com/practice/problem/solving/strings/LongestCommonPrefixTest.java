package com.practice.problem.solving.strings;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonPrefixTest {

    @Test
    public void testCommonPrefix_Input1(){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] inputArray = {"colorado", "color", "cold"};
        Assert.assertEquals("col",longestCommonPrefix.commonPrefix(inputArray,0,inputArray.length-1));
    }

    @Test
    public void testCommonPrefix_Input2(){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] inputArray = {"a", "b", "c"};
        Assert.assertEquals("",longestCommonPrefix.commonPrefix(inputArray,0,inputArray.length-1));
    }

    @Test
    public void testCommonPrefix_Input3(){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] inputArray = {"spot", "spotty", "spotted"};
        Assert.assertEquals("spot",longestCommonPrefix.commonPrefix(inputArray,0,inputArray.length-1));
    }
}


