package com.practice.problem.solving.application.parentchild;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private List<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child){
        this.children.add(child);
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }
}
