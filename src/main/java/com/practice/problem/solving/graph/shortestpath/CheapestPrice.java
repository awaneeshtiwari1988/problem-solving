package com.practice.problem.solving.graph.shortestpath;

import java.util.*;

public class CheapestPrice {

    public Map<String, Vertex> buildGraph(int n, int[][] flights){
        Map<String, Vertex> graph =new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(String.valueOf(i), new Vertex(String.valueOf(i)));
        }

        for(int[] flight : flights){
            String startVertex = String.valueOf(flight[0]);
            String targetVertex = String.valueOf(flight[1]);
            double price = flight[2];

            graph.putIfAbsent(startVertex, new Vertex(startVertex));
            graph.putIfAbsent(targetVertex, new Vertex(targetVertex));

            Vertex sourceVertex = graph.get(startVertex);
            Vertex destinationVertex = graph.get(targetVertex);
            sourceVertex.addNeighbours(new Edge(price, sourceVertex,destinationVertex));
        }

        return graph;
    }

    public int computePath(Map<String,Vertex> graph, String source, String destination, int maxStops) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{Integer.parseInt(source), 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1], stops = current[2];

            // If we reached destination within allowed stops, return cost
            if (String.valueOf(node).equals(destination)) {
                return cost;
            }

            // If exceeded maxStops, skip processing
            if (stops > maxStops) {
                continue;
            }

            // Process neighbors
            for (Edge edge : graph.get(String.valueOf(node)).getAdjacencyList()) {
                Vertex neighbor = edge.getTargetVertex();
                int newCost = cost + (int) edge.getWeight();

                queue.add(new int[]{Integer.parseInt(neighbor.getName()), newCost, stops + 1});
            }
        }

        return -1; // If no path found within constraints
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<String, Vertex> graph = buildGraph(n, flights);
        return computePath(graph, String.valueOf(src),String.valueOf(dst), k);
    }

    public static void main(String[] args) {
        CheapestPrice cheapestPrice = new CheapestPrice();
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int cheapest = cheapestPrice.findCheapestPrice(3, flights,0,2,1);
        System.out.println(cheapest);
    }
}
