package com.practice.problem.solving.application.eventprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class EventProcessor implements Runnable {

    private final BlockingQueue<String> eventQueue;
    private final Map<String, Integer> eventMapToCount;
    private final int windowSize;
    private int eventsProcessed;

    public EventProcessor(BlockingQueue<String> eventQueue, int windowSize) {
        this.eventQueue = eventQueue;
        this.eventMapToCount = new HashMap<>();
        this.eventsProcessed = 0;
        this.windowSize = windowSize;
    }


    @Override
    public void run() {
        while (eventsProcessed < windowSize){
            try{
                String event = eventQueue.take();
                processEvent(event);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                System.err.println("Exception in taking the event for processing "+exception.getMessage());
            }
        }
    }

    public void processEvent(String event){
        eventMapToCount.put(event, eventMapToCount.getOrDefault(event,0) + 1);
        eventsProcessed++;
    }

    public Map<String, Integer> getEventCounts(){
        return eventMapToCount;
    }
}
