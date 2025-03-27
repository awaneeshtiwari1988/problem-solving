package com.practice.problem.solving.strings;

import java.util.HashMap;
import java.util.Map;

public class MaximumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s == null || s.isEmpty() || t == null || t.isEmpty()){
            return "";
        }

        // Frequency Map of string t
        Map<Character, Integer> tCharMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tCharMap.put(ch, tCharMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character,Integer> windowMap = new HashMap<>();
        int windowSize = tCharMap.size();
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int formed = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if(windowMap.containsKey(ch) && windowMap.get(ch).intValue() == tCharMap.get(ch).intValue()){
                formed++;
            }

            while(left <= right && formed == windowSize){
                char ch1 = s.charAt(left);

                if(right - left + 1 < min){
                    min = right - left + 1;
                    start = left;
                }

                windowMap.put(ch1, windowMap.get(ch1) - 1);
                if (tCharMap.containsKey(ch1) && windowMap.get(ch1) < tCharMap.get(ch1)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
