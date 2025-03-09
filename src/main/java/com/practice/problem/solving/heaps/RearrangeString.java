package com.practice.problem.solving.heaps;

import java.util.*;

public class RearrangeString {

    public String reorganizeString(String s) {
        // Create Frequency map of characters
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            frequencyMap.putIfAbsent(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Create Priority Queue:
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder response = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        while(!maxHeap.isEmpty()){
            Character currentChar = maxHeap.poll();
            response.append(currentChar);

            // Update frequencyMap
            frequencyMap.put(currentChar, frequencyMap.get(currentChar) - 1);

            if(!queue.isEmpty() && frequencyMap.get(queue.peek()) > 0){
                maxHeap.add(queue.poll());
            }

            queue.offer(currentChar);
        }

        return response.length() == s.length() ? response.toString() : "";
    }
}
