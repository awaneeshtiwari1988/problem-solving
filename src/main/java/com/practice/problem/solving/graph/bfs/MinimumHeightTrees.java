package com.practice.problem.solving.graph.bfs;

import java.util.*;

public class MinimumHeightTrees {

    public Map<String, Vertex> buildGraph(int n, int[][] edges){
        Map<String, Vertex> graph = new HashMap<>();
        for(int i =0; i < n; i++){
            graph.put(String.valueOf(i), new Vertex(String.valueOf(i)));
        }

        // Populate Graph
        for (int[] edge : edges) {
            Vertex v1 = graph.get(String.valueOf(edge[0]));
            Vertex v2 = graph.get(String.valueOf(edge[1]));
            v1.addNeighbour(v2);
            v2.addNeighbour(v1);
        }

        return graph;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        Map<String, Vertex> graph = buildGraph(n, edges);

        // Initialize Leaves
        List<Vertex> leaves = new ArrayList<>();
        for(Vertex vertex : graph.values()){
            if(vertex.getAdjacencyList().size() == 1){
                leaves.add(vertex);
            }
        }

        // Step 3: Prune Tree Layer by Layer
        while (n > 2) {
            n -= leaves.size();
            List<Vertex> newLeaves = new ArrayList<>();

            for (Vertex leaf : leaves) {
                if(!leaf.getAdjacencyList().isEmpty()){
                    Vertex neighbour = leaf.getAdjacencyList().get(0);
                    neighbour.getAdjacencyList().remove(leaf);

                    if(neighbour.getAdjacencyList().size() == 1){
                        newLeaves.add(neighbour);
                    }
                }

                graph.remove(leaf.getName());
            }

            leaves = newLeaves; // Move to the next level
        }

        // Convert remaining vertices to root labels
        List<Integer> result = new ArrayList<>();
        for (Vertex vertex : leaves) {
            result.add(Integer.parseInt(vertex.getName()));
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        int[][] edges = {{1,0},{1,2},{1,3}};
        System.out.println(minimumHeightTrees.findMinHeightTrees(4, edges));
    }
}
