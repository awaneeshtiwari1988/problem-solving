package com.practice.problem.solving.graph.kruskalalgo;

import java.util.List;

public class DisjointSet {

    public DisjointSet(List<Vertex> vertexList) {
        makeSets(vertexList);
    }

    private void makeSets(List<Vertex> vertexList) {
        for (Vertex vertex : vertexList) {
            makeSet(vertex);
        }
    }

    private void makeSet(Vertex vertex) {
        Node node = new Node(0, null);
        vertex.setNode(node);
    }

    public Node find(Node node){
        Node currentNode = node;
        while (currentNode.getParent() != null){
            currentNode = currentNode.getParent();
        }

        // Perform Path Compression
        Node root = currentNode;
        currentNode = node;
        while(currentNode != root){
            Node temp = currentNode.getParent();
            currentNode.setParent(root);
            currentNode = temp;
        }

        return root;
    }

    public void union(Node node1, Node node2){
        Node root1 = find(node1);
        Node root2 = find(node2);

        if(root1 == root2){
            return ;
        }

        if(root1.getHeight() < root2.getHeight()){
            root1.setParent(root2);
        } else if(root2.getHeight() < root1.getHeight()){
            root2.setParent(root1);
        } else {
            root2.setParent(root1);
            root1.setHeight(root1.getHeight() + 1);
        }
    }

}
