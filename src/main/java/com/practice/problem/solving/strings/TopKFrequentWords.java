package com.practice.problem.solving.strings;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequentBucketSort(String[] words, int k) {
        // Step 1: Create Frequency Map
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Create Bucket
        List<String>[] buckets = new List[words.length + 1];
        for(int i =0; i <= words.length; i++){
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Populate Bucket
        frequencyMap.keySet().forEach(key -> {
            int freq = frequencyMap.get(key);
            buckets[freq].add(key);
        });

        // Step 4: Sort the bucket lexicographically
        for(int i =0; i <= words.length;i++){
            Collections.sort(buckets[i]);
        }

        // Step 5: Create Output List
        List<String> output = new ArrayList<>();
        for(int i = words.length; i >= 0; i--){
            for(String word : buckets[i]){
                output.add(word);
                if(output.size() == k){
                    return output;
                }
            }
        }

        return output;
    }

    public List<String> topKFrequentEfficient(String[] words, int k) {
        // Step 1: Create Frequency Map
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Create Priority Queue Min Heap
        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> {
            if(frequencyMap.get(a).equals(frequencyMap.get(b))){
                return b.compareTo(a);
            }

            return frequencyMap.get(a) - frequencyMap.get(b);
        });

        // Step 3: Populate Priority Queue
        for(String word: frequencyMap.keySet()){
            minHeap.offer(word);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        // Step 4: Create Output
        List<String> output = new ArrayList<>();
        while (!minHeap.isEmpty()){
            output.add(minHeap.poll());
        }

        // Step 5: Reverse the list
        Collections.reverse(output);
        return output;
    }

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequentWords.topKFrequentBucketSort(words, 2));

        System.out.println(topKFrequentWords.topKFrequentEfficient(words, 2));
    }
}
