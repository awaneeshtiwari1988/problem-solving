package com.practice.problem.solving.application.precedencechars;

import java.util.HashMap;
import java.util.Map;

public class GraphBuilder {

    private Map<Character, Node> characterNodeMap;
    private Map<Character, Integer> inDegreeMap;

    public GraphBuilder() {
        this.characterNodeMap = new HashMap<>();
        this.inDegreeMap = new HashMap<>();
    }

    public Map<Character, Integer> getInDegreeMap() {
        return inDegreeMap;
    }

    public Map<Character, Node> buildGraph(String[] words){
        initializeGraph(words);
        buildEdges(words);
        return characterNodeMap;
    }
    private void initializeGraph(String[] words) {
        for (String word: words) {
            for(char c : word.toCharArray()){
                characterNodeMap.putIfAbsent(c, new Node(c));
                inDegreeMap.put(c,0);
            }
        }
    }
    private void buildEdges(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2){
                    Node node1 = characterNodeMap.get(c1);
                    Node node2 = characterNodeMap.get(c2);

                    if(!node1.getNeighbours().contains(node2)){
                        node1.addNeighbour(node2);
                        inDegreeMap.put(c2, inDegreeMap.get(c2)+1);
                    }
                    break;
                }
            }
        }
    }
}
