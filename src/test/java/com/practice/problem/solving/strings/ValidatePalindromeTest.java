package com.practice.problem.solving.strings;

import org.junit.Assert;
import org.junit.Test;

public class ValidatePalindromeTest {

    @Test
    public void testIsPalindrome(){
        ValidatePalindrome validatePalindrome = new ValidatePalindrome();
        Assert.assertTrue(validatePalindrome.isPalindromeUsingBuilder("level"));
        Assert.assertFalse(validatePalindrome.isPalindromeUsingBuilder("algorithm"));
        Assert.assertTrue(validatePalindrome.isPalindromeUsingBuilder("A man, a plan, a canal: Panama."));
    }

    @Test
    public void testIsPalindromeByChars(){
        ValidatePalindrome validatePalindrome = new ValidatePalindrome();
        Assert.assertTrue(validatePalindrome.isPalindromeByTraversalOfString("level"));
        Assert.assertFalse(validatePalindrome.isPalindromeByTraversalOfString("algorithm"));
        Assert.assertTrue(validatePalindrome.isPalindromeByTraversalOfString("A man, a plan, a canal: Panama."));
    }
}
