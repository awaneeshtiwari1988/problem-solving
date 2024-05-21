package com.practice.problem.solving.application.precedencechars;

import java.util.Map;

public class ApplicationRunner {

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};

        GraphBuilder graphBuilder = new GraphBuilder();
        Map<Character, Node> characterNodeMap =  graphBuilder.buildGraph(words);
        Map<Character, Integer> inDegreeMap = graphBuilder.getInDegreeMap();
        TopologicalSortBuilder topologicalSortBuilder = new TopologicalSortBuilder();
        String output = topologicalSortBuilder.sort(characterNodeMap, inDegreeMap);
        System.out.println(output);
    }
}
