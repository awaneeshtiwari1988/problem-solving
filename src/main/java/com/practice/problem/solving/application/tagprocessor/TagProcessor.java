package com.practice.problem.solving.application.tagprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TagProcessor {

    private final Map<String, Integer> tagMapToCount;
    private final int limit;

    public TagProcessor(int limit) {
        this.limit = limit;
        this.tagMapToCount = new HashMap<>();
    }

    public void processTags(String tag){
        if(tagMapToCount.containsKey(tag)){
            tagMapToCount.put(tag, tagMapToCount.getOrDefault(tag,0) + 1);
        } else {
            tagMapToCount.put(tag,1);
        }
    }

    public Map<String, Integer> findMostPopularTag(){
        return tagMapToCount.entrySet().stream().sorted((e1,e2) -> Integer.compare(e2.getValue(),e1.getValue()))
                .limit(this.limit)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
}
