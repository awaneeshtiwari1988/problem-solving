package com.practice.problem.solving.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null){
            return new int[0];
        }

        // Create Frequency Map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create Priority Queue of frequency map
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            heap.offer(entry);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] output = new int[k];
        int index = 0;
        while(!heap.isEmpty()){
            output[index++] = heap.poll().getKey();
        }

        return output;
    }
}
