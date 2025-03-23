package com.practice.problem.solving.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicate {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int left = 0;
        int maxLength = 0;

        // abcabcbb
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for(int right =0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(charIndexMap.containsKey(ch) && charIndexMap.get(ch) >= left){
                left = charIndexMap.get(ch) + 1;
            }

            charIndexMap.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubstringWithoutDuplicate longestSubstringWithoutDuplicate = new LongestSubstringWithoutDuplicate();
        System.out.println(longestSubstringWithoutDuplicate.lengthOfLongestSubstring(s));
    }
}
