package com.practice.problem.solving.hashing;

import java.util.*;

public class NumberOfMatchingSubsequences {

    public int numMatchingSubSequence(String s, String[] words) {
        // Step 1: Create Map of Character to Indices
        Map<Character, List<Integer>> characterIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            characterIndexMap.putIfAbsent(ch, new ArrayList<>());
            characterIndexMap.get(ch).add(i);
        }

        // Step: Check for subsequence of each word
        int count = 0;
        for(String word : words){
            if(isSubsequence(word,characterIndexMap)){
               count++;
            }
        }

        return count;
    }

    private boolean isSubsequence(String word, Map<Character, List<Integer>> characterIndexMap){
        int prevIndex = -1;

        // Step: Check Character by Character
        for(char ch : word.toCharArray()){
            if(!characterIndexMap.containsKey(ch)){
                return false;
            }

            List<Integer> indices = characterIndexMap.get(ch);

            // Step: Binary search to find next valid index
            int nextIndex = binarySearch(indices, prevIndex);
            if(nextIndex == -1){
                return false;
            }

            prevIndex = indices.get(nextIndex);
        }

        return true;
    }

    private int binarySearch(List<Integer> indices, int targetIndex){
        int left = 0;
        int right = indices.size() - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(indices.get(mid) < targetIndex){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return left < indices.size() ? left : -1;
    }

    public static void main(String[] args) {
        String inputString = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();
        System.out.println(numberOfMatchingSubsequences.numMatchingSubSequence(inputString,words));
    }
}
