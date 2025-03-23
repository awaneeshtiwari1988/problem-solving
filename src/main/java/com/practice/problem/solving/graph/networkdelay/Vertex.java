package com.practice.problem.solving.graph.networkdelay;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private String name;
    private double distance;
    private List<Edge> adjacentList;
    private Vertex predecessor;

    public Vertex(String name) {
        this.name = name;
        this.adjacentList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Edge> getAdjacentList() {
        return adjacentList;
    }

    public void addNeighbours(Edge edge) {
        this.adjacentList.add(edge);
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return name + "-" + distance;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.getDistance());
    }

}
