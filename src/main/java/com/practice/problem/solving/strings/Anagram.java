package com.practice.problem.solving.strings;

import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String a, String b){
        boolean isAnagram = true;
        if(a.length() != b.length()){
            isAnagram = false;
        }

        char[] charSetA = a.toCharArray();
        char[] charSetB = b.toCharArray();

        Arrays.sort(charSetA);
        Arrays.sort(charSetB);

        for (int i = 0; i < charSetA.length; i++) {
            if(charSetA[i] != charSetB[i]){
                isAnagram = false;
                break;
            }
        }

        return isAnagram;
    }
}
