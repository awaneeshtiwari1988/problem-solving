package com.practice.problem.solving.graph.ordering;

import java.util.*;

public class TopologicalOrdering {

    public static Map<String, Vertex> buildGraph(int[][] edges){
        Map<String, Vertex> graph = new HashMap<>();
        for(int[] edge : edges){
            String startVertex = String.valueOf(edge[0]);
            String endVertex = String.valueOf(edge[1]);
            graph.putIfAbsent(startVertex, new Vertex(startVertex));
            graph.putIfAbsent(endVertex, new Vertex(endVertex));
            graph.get(startVertex).addNeighbours(new Vertex(endVertex));
        }

        return graph;
    }

    public static void depthFirstSearch(Vertex vertex, Stack<Vertex> stack){
        vertex.setBeingVisited(true);
        for (Vertex neighbourVertex : vertex.getAdjacencyList()) {
            if(!neighbourVertex.isVisited()){
                depthFirstSearch(neighbourVertex,stack);
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
        stack.push(vertex);
    }

    public static List<Vertex> topologicalSort(Map<String, Vertex> graph){
        List<Vertex> result = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();

        for(Vertex vertex : graph.values()){
            if(!vertex.isVisited()){
                depthFirstSearch(vertex, stack);
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] edges = { {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1} };
        Map<String, Vertex> graph = buildGraph(edges);
        graph.forEach((k,v) -> System.out.println(v));
    }

}
