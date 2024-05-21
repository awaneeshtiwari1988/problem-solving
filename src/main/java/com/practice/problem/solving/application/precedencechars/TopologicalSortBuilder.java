package com.practice.problem.solving.application.precedencechars;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortBuilder {

    public String sort(Map<Character, Node> graph, Map<Character, Integer> inDegreeMap){
        Queue<Character> queue = new LinkedList<>();
        inDegreeMap.forEach((key,value) -> {
            if(value == 0){
                queue.add(key);
            }
        });

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()){
            char current = queue.poll();
            order.append(current);

            for(Node neighbor : graph.get(current).getNeighbours()){
                char neighborChar = neighbor.getCharacter();
                inDegreeMap.put(neighborChar, inDegreeMap.get(neighborChar) - 1);
                if(inDegreeMap.get(neighborChar) == 0){
                    queue.add(neighborChar);
                }
            }
        }

        if(order.length() != graph.size()){
            return "";
        }

        return order.toString();
    }
}
