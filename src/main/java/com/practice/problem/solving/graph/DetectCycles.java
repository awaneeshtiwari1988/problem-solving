package com.practice.problem.solving.graph;

import java.util.Map;

public class DetectCycles {

    public boolean detectCycles(Map<String, Vertex> graph) {
        for (Vertex vertex : graph.values()) {
            if (!vertex.isVisited()) {
                if (depthFirstSearch(vertex)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean depthFirstSearch(Vertex vertex) {
        vertex.setBeingVisited(true);

        for (Vertex neighbourVertex : vertex.getNeighbours()) {
            if (neighbourVertex.isBeingVisited()) {
                return true; // Cycle detected
            }

            if (!neighbourVertex.isVisited()) {
                if (depthFirstSearch(neighbourVertex)) {
                    return true; // Cycle detected in recursion
                }
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);

        return false;
    }
}
