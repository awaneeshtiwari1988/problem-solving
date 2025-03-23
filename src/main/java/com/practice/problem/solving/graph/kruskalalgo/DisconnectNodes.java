package com.practice.problem.solving.graph.kruskalalgo;

import java.util.*;

public class DisconnectNodes {

    public int[] findRedundantConnection(int[][] edges) {
        Map<String, Vertex> graph = buildGraph(edges);
        List<Vertex> vertexList = new ArrayList<>(graph.values());
        List<Edge> edgeList = buildEdges(graph, edges);

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        return kruskalAlgorithm.redundantConnection(vertexList, edgeList);
    }

    public Map<String, Vertex> buildGraph(int[][] edges){
        Map<String, Vertex> graph = new HashMap<>();
        for(int[] edge : edges){
            String start = String.valueOf(edge[0]);
            String end = String.valueOf(edge[1]);

            graph.putIfAbsent(start, new Vertex(start));
            graph.putIfAbsent(end, new Vertex(end));
        }

        return graph;
    }

    public List<Edge> buildEdges(Map<String,Vertex> graph, int[][] edges){
        List<Edge> edgeList = new ArrayList<>();
        for(int[] edge : edges){
            Vertex source = graph.get(String.valueOf(edge[0]));
            Vertex target = graph.get(String.valueOf(edge[1]));
            edgeList.add(new Edge(source, target));
        }

        return edgeList;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        DisconnectNodes disconnectNodes = new DisconnectNodes();
        System.out.println(Arrays.toString(disconnectNodes.findRedundantConnection(edges)));

    }

}
