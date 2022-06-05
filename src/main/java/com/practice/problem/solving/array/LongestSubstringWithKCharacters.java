package com.practice.problem.solving.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKCharacters {

    public int getLongestSubstringWithKCharacters(String str, int k){
        if(str == null || str.length() == 0){
            throw new IllegalArgumentException("Please provide a valid string");
        }

        int startIndex = 0;
        int maxLength = 0;
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);

            while (characterFrequencyMap.size() > k) {
                char leftChar = str.charAt(startIndex);
                characterFrequencyMap.put(leftChar, characterFrequencyMap.get(leftChar) - 1);
                if(characterFrequencyMap.get(leftChar) == 0){
                    characterFrequencyMap.remove(leftChar);
                }

                startIndex++;
            }

            maxLength = Math.max(maxLength, i - startIndex +1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithKCharacters longestSubstringWithKCharacters = new LongestSubstringWithKCharacters();
        System.out.println(longestSubstringWithKCharacters.getLongestSubstringWithKCharacters("araaci",2));
        System.out.println(longestSubstringWithKCharacters.getLongestSubstringWithKCharacters("araaci",1));
        System.out.println(longestSubstringWithKCharacters.getLongestSubstringWithKCharacters("cbbebi",3));
    }
}
