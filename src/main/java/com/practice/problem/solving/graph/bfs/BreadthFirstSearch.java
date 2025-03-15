package com.practice.problem.solving.graph.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {

    public static int countIslands(int[][] grid){
        Map<String, Vertex> graph = buildGraph(grid);
        int islandCount = 0;

        for(Vertex vertex : graph.values()){
            if(!vertex.isVisited()){
                breadthFirstSearch(vertex);
                islandCount++;
            }
        }

        return islandCount;
    }

    public static Map<String, Vertex> buildGraph(int[][] grid) {
        Map<String, Vertex> graph = new HashMap<>();

        int rows = grid.length;
        int columns = grid[0].length;

        // Create vertices of the graph for each grid cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    String name = i + "," + j;
                    graph.put(name, new Vertex(name));
                }
            }
        }

        // Add neighbours for each vertex
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    String name = i + "," + j;
                    Vertex vertex = graph.get(name);

                    if (i > 0 && grid[i - 1][j] == 1) {
                        String upVertex = (i - 1) + "," + j;
                        vertex.addNeighbour(graph.get(upVertex));
                    }

                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        String downVertex = (i + 1) + "," + j;
                        vertex.addNeighbour(graph.get(downVertex));
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        String leftVertex = i + "," + (j - 1);
                        vertex.addNeighbour(graph.get(leftVertex));
                    }

                    if (j < columns - 1 && grid[i][j + 1] == 1) {
                        String rightVertex = i + "," + (j + 1);
                        vertex.addNeighbour(graph.get(rightVertex));
                    }
                }
            }
        }

        return graph;
    }

    private static void breadthFirstSearch(Vertex vertex){
        Queue<Vertex> queue = new LinkedList<>();
        vertex.setVisited(true);
        queue.add(vertex);

        while(!queue.isEmpty()){
            Vertex currentVertex = queue.poll();
            for(Vertex vert : currentVertex.getAdjacencyList()){
                if(!vert.isVisited()){
                    vert.setVisited(true);
                    queue.add(vert);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        int islandCount = countIslands(grid);
        System.out.println(islandCount);
    }

}
