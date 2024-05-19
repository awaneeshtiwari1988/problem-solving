package com.practice.problem.solving.application.tagprocessor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class TagsStreaming {

    private final BlockingQueue<String> tageStreamingQueue;
    private final TagProcessor tagProcessor;
    private final int limit;
    private int tagsProcessed;
    private final ExecutorService executorService;

    public TagsStreaming(TagProcessor tagProcessor, int limit) {
        this.tageStreamingQueue = new LinkedBlockingQueue<>();
        this.tagProcessor = tagProcessor;
        this.limit = limit;
        this.tagsProcessed = 0;
        this.executorService = Executors.newFixedThreadPool(4);
    }

    public void startProducingItems(List<String> tags){
        executorService.submit(() -> produceItemsOnQueue(tags));
    }

    public void startConsumingItems(){
        for(int i =0; i < 4; i++){
            executorService.submit(this::consumerItemsFromQueue);
        }
    }

    private void produceItemsOnQueue(List<String> tags) {
        try {
            for (String tag : tags) {
                tageStreamingQueue.put(tag);

                // Simulate delay between threads
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Exception due to " + e.getMessage());
        }
    }

    private void consumerItemsFromQueue() {
        try {
            while (tagsProcessed < limit) {
                String tag = tageStreamingQueue.take();
                tagProcessor.processTags(tag);
                tagsProcessed++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Exception due to " + e.getMessage());
        }
    }

    public String getMostPopularTag(){
        Map<String, Integer> tagCountMap = this.tagProcessor.findMostPopularTag();
        if(tagCountMap.entrySet().stream().findFirst().isPresent()){
            return tagCountMap.entrySet().stream().findFirst().get().getKey();
        }

        return "";
    }

    public void shutDown(){
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.MINUTES)){
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            executorService.shutdown();
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }
}
