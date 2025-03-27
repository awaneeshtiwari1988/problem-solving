package com.practice.problem.solving.strings;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()){
            return false;
        }

        Map<Character, Integer> s1FrequencyMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Populate s1FrequencyMap
        for(char ch : s1.toCharArray()){
            s1FrequencyMap.put(ch, s1FrequencyMap.getOrDefault(ch, 0) + 1);
        }

        int windowSize = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if(i >= windowSize){
                char leftChar = s2.charAt(i - windowSize);
                if(windowMap.get(leftChar) == 1){
                    windowMap.remove(leftChar);
                } else {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
            }

            if(windowMap.equals(s1FrequencyMap)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        StringPermutation stringPermutation = new StringPermutation();
        System.out.println(stringPermutation.checkInclusion(s1, s2));
    }
}
