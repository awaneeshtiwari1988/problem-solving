package com.practice.problem.solving.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
            return visited;
        }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbour(Vertex vertex) {
        this.adjacencyList.add(vertex);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", visited=" + visited +
                '}';
    }
}
