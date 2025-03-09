package com.practice.problem.solving.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String vertexName;
    private List<Vertex> adjacentList;

    // When performing Cycle Detection
    private boolean beingVisited;
    private boolean visited;

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(String vertexName) {
        this.vertexName = vertexName;
        this.adjacentList = new ArrayList<>();
    }

    public List<Vertex> getNeighbours() {
        return adjacentList;
    }

    public void addNeighbours(Vertex vertex) {
        this.adjacentList.add(vertex);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertexName='" + vertexName + '\'' +
                ", adjacentList=" + adjacentList +
                ", beingVisited=" + beingVisited +
                ", visited=" + visited +
                '}';
    }
}
