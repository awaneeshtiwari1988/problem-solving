package com.practice.problem.solving.graph.networkdelay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<String, Vertex> graph = buildGraph(times,n);
        Vertex source = graph.get(String.valueOf(k));
        ShortestPathAlgorithm shortestPathAlgorithm = new ShortestPathAlgorithm();
        shortestPathAlgorithm.computePath(source);
        double maximumDelay = Double.MIN_VALUE;
        for(Vertex vertex : graph.values()){
            if(vertex.getDistance() == Double.MAX_VALUE){
                return -1;
            }

            maximumDelay = Math.max(maximumDelay, vertex.getDistance());
        }

        return (int) maximumDelay;
    }

    private Map<String, Vertex> buildGraph(int[][] times, int n){
        // Create graph of vertices
        Map<String, Vertex> graph = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String vertexName = String.valueOf(i);
            graph.put(vertexName, new Vertex(vertexName));
        }

        // Populate Weight by edge and Adjacency List
        for(int[] edges : times){
            String startVertex = String.valueOf(edges[0]);
            String targetVertex = String.valueOf(edges[1]);
            double weight = edges[2];

            graph.putIfAbsent(startVertex, new Vertex(startVertex));
            graph.putIfAbsent(targetVertex, new Vertex(targetVertex));

            Vertex source = graph.get(startVertex);
            Vertex destination = graph.get(targetVertex);
            source.addNeighbours(new Edge(weight,source,destination));
        }

        return graph;
    }


    public static void main(String[] args) {
        int[][] edges = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(edges, 4, 2));
    }
}
