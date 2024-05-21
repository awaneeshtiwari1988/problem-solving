package com.practice.problem.solving.application.parentchild;

import java.util.HashMap;
import java.util.Map;

public class Tree {

    private Node root;
    private Map<String, Node> nodes;

    public Tree() {
        this.nodes = new HashMap<>();
    }

    public void addRelation(String parentName, String childName){
        Node parent = nodes.computeIfAbsent(parentName,Node::new);
        Node child = nodes.computeIfAbsent(childName, Node::new);

        parent.addChild(child);

        if(root == null || root.getName().equalsIgnoreCase(childName)){
            root = parent;
        }
    }

    public void printTree(){
        if(root != null){
            printTree(root, 0);
        }
    }
    
    public void printTree(Node root, int level){
        for (int i = 0; i < level; i++) {
            System.out.println(" ");
        }

        System.out.println(root.getName());

        for (Node node : root.getChildren()){
            printTree(node, level + 1);
        }
    }
}
