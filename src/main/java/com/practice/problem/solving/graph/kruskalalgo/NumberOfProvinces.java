package com.practice.problem.solving.graph.kruskalalgo;

import java.util.*;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        Map<String, Vertex> graph = buildGraph(isConnected);
        List<Vertex> vertexList = new ArrayList<>(graph.values());
        List<Edge> edgeList = buildEdges(graph, isConnected);

        DisjointSet disjointSet = new DisjointSet(vertexList);

        for(Edge edge : edgeList){
            Vertex startVertex = edge.getStartVertex();
            Vertex targetVertex = edge.getTargetVertex();
            disjointSet.union(startVertex.getNode(), targetVertex.getNode());
        }

        Set<Node> uniqueNodes = new HashSet<>();
        for(Vertex vertex : vertexList){
            uniqueNodes.add(disjointSet.find(vertex.getNode()));
        }

        return uniqueNodes.size();
    }

    public Map<String, Vertex> buildGraph(int[][] isConnected){
        Map<String, Vertex> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            graph.putIfAbsent(String.valueOf(i), new Vertex(String.valueOf(i)));
        }

        return graph;
    }

    public List<Edge> buildEdges(Map<String,Vertex> graph, int[][] isConnected){
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1){
                    Vertex startVertex = graph.get(String.valueOf(i));
                    Vertex targetVertex = graph.get(String.valueOf(j));
                    edgeList.add(new Edge(startVertex,targetVertex));
                }
            }
        }

        return edgeList;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        System.out.println(numberOfProvinces.findCircleNum(isConnected));
    }
}
