package com.practice.problem.solving.application.precedencechars;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private Character character;
    private Set<Node> neighbours;

    public Node(Character character) {
        this.character = character;
        this.neighbours = new HashSet<>();
    }

    public Character getCharacter() {
        return character;
    }

    public Set<Node> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Node neighbour){
        this.neighbours.add(neighbour);
    }
}
