package com.practice.problem.solving.graph.detectcycles;

public class GraphApplication {

    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("C");

        vertexA.addNeighbours(vertexC);
        vertexA.addNeighbours(vertexB);
        vertexB.addNeighbours(vertexD);
    }
}
