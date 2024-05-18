package com.practice.problem.solving.application.eventprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventFinder {

    private final BlockingQueue<String> eventBlockingQueue;
    private final int windowSize;


    public EventFinder(int windowSize) {
        this.eventBlockingQueue = new LinkedBlockingQueue<>();
        this.windowSize = windowSize;
    }

    public void addEvent(String event) {
        try {
            eventBlockingQueue.put(event);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String findMostPopularEvent() {
        EventProcessor eventProcessor = new EventProcessor(eventBlockingQueue, windowSize);

        Thread thread = new Thread(eventProcessor);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Map<String, Integer> totalCountMap = new HashMap<>(eventProcessor.getEventCounts());
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        priorityQueue.addAll(totalCountMap.entrySet());
        return Objects.nonNull(priorityQueue.peek()) ? priorityQueue.peek().getKey() : "";
    }
}
