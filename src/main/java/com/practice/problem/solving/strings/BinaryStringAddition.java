package com.practice.problem.solving.strings;

import java.util.Objects;

public class BinaryStringAddition {

    public String getBinaryStringAddition(String str1, String str2){
        return Integer.toBinaryString(Integer.parseInt(str1,2) + Integer.parseInt(str2, 2));
    }
}
