package com.practice.problem.solving.graph.kruskalalgo;

public class Vertex {

    private String name;
    private Node node;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
