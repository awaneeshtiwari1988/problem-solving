package com.practice.problem.solving.strings;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void testIsAnagram(){
        Anagram anagram = new Anagram();
        Assert.assertTrue(anagram.isAnagram("cat","tac"));
        Assert.assertTrue(anagram.isAnagram("listen","silent"));
        Assert.assertFalse(anagram.isAnagram("program","function"));
    }
}
