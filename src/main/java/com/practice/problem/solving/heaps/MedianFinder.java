package com.practice.problem.solving.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);

        // top of maxheap should be <= than of minheap
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }

        // Maxheap size should be greater than Min Heap by 1 or equal to it
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() >maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}
