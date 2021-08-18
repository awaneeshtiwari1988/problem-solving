package com.practice.problem.solving.strings;

import java.util.Objects;

/**
 * Given two binary strings (strings containing only 1s and 0s) return their sum (also as a binary string).
 * Note: neither binary string will contain leading 0s unless the string itself is 0
 */
public class BinaryStringAddition {

    public String getBinaryStringAddition(String str1, String str2){
        return Integer.toBinaryString(Integer.parseInt(str1,2) + Integer.parseInt(str2, 2));
    }
}
