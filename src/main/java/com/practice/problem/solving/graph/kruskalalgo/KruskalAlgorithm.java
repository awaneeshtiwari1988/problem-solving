package com.practice.problem.solving.graph.kruskalalgo;

import java.util.ArrayList;
import java.util.List;

public class KruskalAlgorithm {

    public List<Edge> kruskalAlgorithm(List<Vertex> vertexList,List<Edge> edges){
        DisjointSet disjointSet = new DisjointSet(vertexList);
        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : edges) {
            Vertex start = edge.getStartVertex();
            Vertex target = edge.getTargetVertex();

            if(disjointSet.find(start.getNode()) != disjointSet.find(target.getNode())){
                minimumSpanningTree.add(edge);
            }

            disjointSet.union(start.getNode(), target.getNode());
        }

        return minimumSpanningTree;
    }

    public int[] redundantConnection(List<Vertex> vertexList,List<Edge> edges){
        DisjointSet disjointSet = new DisjointSet(vertexList);
        for (Edge edge : edges) {
            Vertex start = edge.getStartVertex();
            Vertex target = edge.getTargetVertex();

            if(disjointSet.find(start.getNode()) == disjointSet.find(target.getNode())){
                return new int[]{Integer.parseInt(start.getName()), Integer.parseInt(target.getName())};
            }

            disjointSet.union(start.getNode(), target.getNode());
        }

        return new int[0];
    }

}
