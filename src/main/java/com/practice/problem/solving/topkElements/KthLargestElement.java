package com.practice.problem.solving.topkElements;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int kthLargestElement(int[] inputArray, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : inputArray) {
            if(minHeap.size() < k){
                minHeap.offer(num);
            } else if (minHeap.peek() < num){
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int output = kthLargestElement(new int[]{7, 10, 4, 3, 20, 15},3);
        System.out.println(output);
    }
}
