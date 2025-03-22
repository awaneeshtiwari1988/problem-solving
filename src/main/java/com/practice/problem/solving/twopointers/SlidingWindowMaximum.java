package com.practice.problem.solving.twopointers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i >= k - 1){
                output[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return output;
    }

    public int[] maxSlidingWindowHeap(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int[] output = new int[nums.length - k + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        // Initial Window
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{nums[i],i});
        }
        output[0] = heap.peek()[0];
        // Perform sliding window operation
        for (int i = k; i < nums.length; i++) {
            heap.offer(new int[]{nums[i],i});

            while(heap.peek()[1] <= i - k){
                heap.poll();
            }

            output[i-k+1] = heap.peek()[0];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(nums, 3)));
    }
}
