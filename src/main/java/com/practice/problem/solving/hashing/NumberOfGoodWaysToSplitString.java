package com.practice.problem.solving.hashing;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodWaysToSplitString {

    public int numSplits(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        Map<Character, Integer> splitMap = new HashMap<>();

        // Populate FrequencyMap
        for(char ch : s.toCharArray()){
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        int goodSplitPairs = 0;
        for(char ch : s.toCharArray()){
            // Put Character from frequencyMap to splitMap
            splitMap.put(ch, splitMap.getOrDefault(ch, 0) + 1);
            frequencyMap.put(ch, frequencyMap.get(ch)  - 1);
            if(frequencyMap.get(ch) == 0){
                frequencyMap.remove(ch);
            }

            if(frequencyMap.size() == splitMap.size()){
                goodSplitPairs++;
            }
        }

        return goodSplitPairs;
    }

    public static void main(String[] args) {
        String inputString = "aacaba";
        NumberOfGoodWaysToSplitString numberOfGoodWaysToSplitString = new NumberOfGoodWaysToSplitString();
        System.out.println(numberOfGoodWaysToSplitString.numSplits(inputString));
    }
}
