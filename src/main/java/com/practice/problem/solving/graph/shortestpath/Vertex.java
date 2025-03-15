package com.practice.problem.solving.graph.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

    private String name;
    private boolean visited;
    private double distance;
    private Vertex predecessor;

    public String getName() {
        return name;
    }

    private List<Edge> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbours(Edge edge) {
        this.adjacencyList.add(edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", visited=" + visited +
                ", distance=" + distance +
                ", predecessor=" + predecessor +
                '}';
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.getDistance());
    }
}
