package com.practice.problem.solving.graph.networkdelay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathAlgorithm {

    public void computePath(Vertex source){
        source.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()){
            Vertex actualVertex = queue.poll();
            for(Edge edge : actualVertex.getAdjacentList()){
                Vertex targetVertex = edge.getDestinationVertex();
                double distance = actualVertex.getDistance() + edge.getWeight();
                if(distance < targetVertex.getDistance()){
                    queue.remove(targetVertex);
                    targetVertex.setDistance(distance);
                    targetVertex.setPredecessor(actualVertex);
                    queue.add(targetVertex);
                }
            }
        }
    }

    public List<Vertex> shortestPath(Vertex targetVertex){
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()){
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}
