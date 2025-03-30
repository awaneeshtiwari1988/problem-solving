package com.practice.problem.solving.queues;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }

        // Create Frequency Map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            frequencyMap.put(tasks[i], frequencyMap.getOrDefault(tasks[i],0) + 1);
        }

        // Use Max Heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(frequencyMap.values());

        // Use Queue
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while(!heap.isEmpty() || !queue.isEmpty()){
            time++;

            if(!heap.isEmpty()){
                int count = heap.poll() - 1;
                if(count > 0) {
                    queue.add(new int[]{count, time + n});
                }
            }

            if(!queue.isEmpty() && queue.peek()[1] == time){
                heap.offer(queue.poll()[0]);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(scheduler.leastInterval(tasks, n)); // Output: 8
    }
}
