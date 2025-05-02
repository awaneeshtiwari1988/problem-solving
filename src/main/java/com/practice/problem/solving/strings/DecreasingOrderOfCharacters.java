package com.practice.problem.solving.strings;

import java.util.*;

public class DecreasingOrderOfCharacters {

    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder outputString = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            outputString.append(String.valueOf(current).repeat(frequencyMap.get(current)));
        }

        return outputString.toString();
    }

    public String frequencyBucketSort(String s) {

        //Step 1: Create Frequency Map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create Buckets
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Populate Buckets
        frequencyMap.keySet().forEach(key -> {
            int freq = frequencyMap.get(key);
            buckets[freq].add(key);
        });

        // Step 4: Build the output String
        StringBuilder outputString = new StringBuilder();
        for(int i = s.length(); i > 0; i-- ){
           for(char ch : buckets[i]){
               outputString.append(String.valueOf(ch).repeat(frequencyMap.get(ch)));
           }
        }

        return outputString.toString();
    }


    public static void main(String[] args) {
        DecreasingOrderOfCharacters decreasingOrderOfCharacters = new DecreasingOrderOfCharacters();
        String s = "tree";
        System.out.println(decreasingOrderOfCharacters.frequencySort(s));

        System.out.println(decreasingOrderOfCharacters.frequencyBucketSort(s));
    }
}
