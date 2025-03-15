package com.practice.problem.solving.graph.ordering;

import java.util.*;

public class TopologicalOrdering {

    public static Map<String, Vertex> buildGraph(int numCourses, int[][] preRequisites) {
        Map<String, Vertex> graph = new HashMap<>();

        // Create the graph
        for (int i = 0; i < numCourses; i++) {
            String courseName = String.valueOf(i);
            graph.put(courseName, new Vertex(courseName));
        }

        // Add the Neighbours
        for (int[] preRequisite : preRequisites) {
            String course = String.valueOf(preRequisite[0]);
            String preRequisiteCourse = String.valueOf(preRequisite[1]);
            graph.get(preRequisiteCourse).addNeighbours(graph.get(course));
        }

        return graph;
    }

    public static boolean depthFirstSearch(Vertex vertex, Stack<Vertex> stack){
        vertex.setBeingVisited(true);

        for (Vertex neighbourVertex : vertex.getAdjacencyList()) {
            if (neighbourVertex.isBeingVisited()) {
                return true; // Cycle detected
            }

            if (!neighbourVertex.isVisited()) {
                if (depthFirstSearch(neighbourVertex,stack)) {
                    return true; // Cycle detected in recursion
                }
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
        stack.push(vertex);
        return false;
    }

    public static List<String> topologicalSort(Map<String, Vertex> graph){
        List<String> result = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();

        for(Vertex vertex : graph.values()){
            if(!vertex.isVisited()){
                if(depthFirstSearch(vertex, stack)){
                    return new ArrayList<>();
                }
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop().getName());
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] preRequisites = { {1, 0}};
        Map<String, Vertex> graph = buildGraph(2,preRequisites);
        List<String> ordered = topologicalSort(graph);
        System.out.println(ordered);
    }

}
