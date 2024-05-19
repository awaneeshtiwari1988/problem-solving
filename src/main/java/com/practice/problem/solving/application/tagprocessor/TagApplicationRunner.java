package com.practice.problem.solving.application.tagprocessor;

import java.util.Arrays;

public class TagApplicationRunner {

    public static void main(String[] args) {
        String[] tags = {"java", "javascript", "java", "python", "java","java","c++","javascript","java"};
        int numOfConsumerThreads = 4;

        TagsStreaming tagsStreaming = new TagsStreaming(new TagProcessor(5),numOfConsumerThreads);
        tagsStreaming.startProducingItems(Arrays.asList(tags));
        tagsStreaming.startConsumingItems();

        System.out.println(tagsStreaming.getMostPopularTag());
        tagsStreaming.shutDown();
    }
}
