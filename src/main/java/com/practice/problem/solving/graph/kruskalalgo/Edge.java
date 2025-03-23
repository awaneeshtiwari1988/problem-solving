package com.practice.problem.solving.graph.kruskalalgo;

public class Edge {
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(Vertex startVertex, Vertex targetVertex) {
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }
    public Vertex getTargetVertex() {
        return targetVertex;
    }
}
