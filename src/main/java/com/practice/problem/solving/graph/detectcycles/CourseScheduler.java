package com.practice.problem.solving.graph.detectcycles;

import java.util.HashMap;
import java.util.Map;

public class CourseScheduler {

    public Map<String, Vertex> buildGraph(int numCourses, int[][] preRequisites) {
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<String, Vertex> graph = buildGraph(numCourses, prerequisites);
        DetectCycles detectCycles = new DetectCycles();
        return !detectCycles.detectCycles(graph);
    }

    public static void main(String[] args) {
        CourseScheduler courseScheduler = new CourseScheduler();
        int[][] preRequisites = { {1, 0}, {2, 1}, {3, 2}, {4, 3}, {1, 4} };
        boolean canFinish = courseScheduler.canFinish(5, preRequisites);
        System.out.println("Can finish the course: " + canFinish);
    }
}
