package com.practice.problem.solving.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters {

    public int findMaxLength(String str){
        if(str == null || str.length() == 0) {
            return 0;
        }

        int startIndex = 0, maxLength = 0;
        Map<Character, Integer> characterIndexMap = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (characterIndexMap.containsKey(ch)) {
                startIndex = Math.max(startIndex, characterIndexMap.get(ch) + 1);
            }

            characterIndexMap.put(ch, i);
            maxLength = Math.max(maxLength, i - startIndex + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithDistinctCharacters longestSubstringWithDistinctCharacters = new LongestSubstringWithDistinctCharacters();
        System.out.println(longestSubstringWithDistinctCharacters.findMaxLength("aabccbb"));
        System.out.println(longestSubstringWithDistinctCharacters.findMaxLength("abbbb"));
        System.out.println(longestSubstringWithDistinctCharacters.findMaxLength("abccde"));
    }
}
