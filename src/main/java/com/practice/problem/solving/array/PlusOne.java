package com.practice.problem.solving.array;

import java.math.BigInteger;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return new int[0];
        }

        for (int i = digits.length - 1; i >= 0 ; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
