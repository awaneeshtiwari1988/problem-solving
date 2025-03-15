package com.practice.problem.solving.graph.shortestpath;

import java.util.*;

public class DijkstraAlgorithm {

    public Map<String, Vertex> buildGraph(int[][] edges ){
        Map<String, Vertex> graph = new HashMap<>();

        for(int[] edge : edges){
            String startVertex = String.valueOf(edge[0]);
            String targetVertex = String.valueOf(edge[1]);
            double weight = edge[2];

            graph.putIfAbsent(startVertex, new Vertex(startVertex));
            graph.putIfAbsent(targetVertex, new Vertex(targetVertex));

            Vertex sourceVertex = graph.get(startVertex);
            Vertex destinationVertex = graph.get(targetVertex);
            sourceVertex.addNeighbours(new Edge(weight, sourceVertex,destinationVertex));
        }

        return graph;
    }

    public void computePath(Vertex source){
        source.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            for(Edge edge : currentVertex.getAdjacencyList()){
                Vertex v = edge.getTargetVertex();
                double d = currentVertex.getDistance() + edge.getWeight();
                if(d < v.getDistance()){
                    queue.remove(v);
                    v.setDistance(d);
                    v.setPredecessor(currentVertex);
                    queue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPath(Vertex targetVertex){
        List<Vertex> path = new ArrayList<>();
        for(Vertex vertex = targetVertex;vertex != null; vertex = vertex.getPredecessor()){
            path.add(vertex);
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 4},
                {0, 2, 3},
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 4}
        };
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        Map<String, Vertex> graph = dijkstraAlgorithm.buildGraph(edges);
        Vertex source = graph.get("0");
        dijkstraAlgorithm.computePath(source);
        for(Vertex vertex : graph.values()){
            List<Vertex> path = dijkstraAlgorithm.getShortestPath(vertex);
            System.out.print("Shortest path to vertex " + vertex + ": ");
            path.forEach(v -> System.out.print(v.getName()+ " "));
            System.out.println("(Distance: " + vertex.getDistance() + ")");
        }
    }

}
