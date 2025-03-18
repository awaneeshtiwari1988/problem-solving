package com.practice.problem.solving.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {

    public static int[] kLargestElements(int[] nums, int k){
        if (nums == null || nums.length < k){
            return nums;
        }

        int[] output = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int num : nums){
            maxHeap.offer(num);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        for (int i =0; i < k;i++){
            output[i] = maxHeap.poll();
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(Arrays.toString(kLargestElements(nums, 2)));
    }

}
