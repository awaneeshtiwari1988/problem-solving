package com.practice.problem.solving.graph.ordering;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CourseScheduleOrdering {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || numCourses == 0){
            return new int[0];
        }
        Map<String, Vertex> graph = buildGraph(numCourses, prerequisites);
        Stack<Vertex> stack = new Stack<>();

        for(Vertex vertex : graph.values()){
            if(!vertex.isVisited()){
                if(depthFirstSearch(vertex, stack)){
                    return new int[0];
                }
            }
        }

        int[] courseOrder = new int[numCourses];
        for(int i =0; i < numCourses; i++){
            courseOrder[i] = Integer.parseInt(stack.pop().getName());
        }

        return courseOrder;
    }

    private Map<String, Vertex> buildGraph(int numCourses, int[][] prerequisites){
        Map<String, Vertex> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(String.valueOf(i), new Vertex(String.valueOf(i)));
        }

        // Add neighbours
        for(int[] preReq : prerequisites){
            String course = String.valueOf(preReq[0]);
            String preCourse = String.valueOf(preReq[1]);
            graph.get(preCourse).addNeighbours(graph.get(course));
        }

        return graph;
    }

    private boolean depthFirstSearch(Vertex vertex, Stack<Vertex> stack){
        vertex.setBeingVisited(true);

        for(Vertex neighbour : vertex.getAdjacencyList()){
            if(neighbour.isBeingVisited()){
                return true;
            }

            if(!neighbour.isVisited()){
                if(depthFirstSearch(neighbour, stack)){
                    return true;
                }
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
        stack.push(vertex);

        return false;
    }

    public static void main(String[] args) {
        int[][] preRequisites = {{1,0}};
        CourseScheduleOrdering courseScheduleOrdering = new CourseScheduleOrdering();
        System.out.println(Arrays.toString(courseScheduleOrdering.findOrder(2, preRequisites)));
    }
}
