package com.practice.problem.solving.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithReplacement {

    public int findLengthOfLongestSubstringWithCharReplacement(String str, int k){
        int startIndex = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            characterFrequencyMap.put(rightChar, characterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, characterFrequencyMap.get(rightChar));

            if(i - startIndex + 1 - maxRepeatLetterCount > k){
                char leftChar = str.charAt(startIndex);
                characterFrequencyMap.put(leftChar, characterFrequencyMap.get(leftChar) - 1);
                startIndex++;
            }

            maxLength = Math.max(maxLength, i - startIndex + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithReplacement longestSubstringWithReplacement = new LongestSubstringWithReplacement();
        System.out.println(longestSubstringWithReplacement.findLengthOfLongestSubstringWithCharReplacement("aabccbb", 2));
        System.out.println(longestSubstringWithReplacement.findLengthOfLongestSubstringWithCharReplacement("abbcb", 1));
        System.out.println(longestSubstringWithReplacement.findLengthOfLongestSubstringWithCharReplacement("abccde", 1));
    }
}
