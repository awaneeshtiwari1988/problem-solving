package com.practice.problem.solving.graph.bfs;

import java.util.*;

public class ConnectedGraph {

    public static boolean areNodesConnected(int nodes, int[][] edges){
        Map<String, Vertex> graph = buildGraph(nodes, edges);

        // Perform BFS with this graph
        Queue<Vertex> queue = new LinkedList<>();
        Vertex currentVertex = graph.get("0");
        queue.offer(currentVertex);
        currentVertex.setVisited(true);

        int visitedCount = 0;
        while(!queue.isEmpty()){
            currentVertex = queue.poll();
            visitedCount++;

            for(Vertex neighbour : currentVertex.getAdjacencyList()){
                if(!neighbour.isVisited()){
                    queue.offer(neighbour);
                    neighbour.setVisited(true);
                }
            }
        }

        return visitedCount == nodes;
    }

    public static Map<String, Vertex> buildGraph(int nodes, int[][] edges){
        if(edges == null){
            return Collections.emptyMap();
        }

        Map<String, Vertex> graph = new HashMap<>();

        // Build Graph from nodes
        for(int i =0; i < nodes; i++){
            String vertexName = String.valueOf(i);
            graph.put(vertexName, new Vertex(vertexName));
        }

        // Add adjacency List to the graph
        for(int[] edge : edges){
            Vertex sourceVertex = graph.get(String.valueOf(edge[0]));
            Vertex targetVertex = graph.get(String.valueOf(edge[1]));
            sourceVertex.addNeighbour(targetVertex);
            targetVertex.addNeighbour(sourceVertex);
        }

        return graph;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(areNodesConnected(4, edges));
    }

}
