package com.practice.problem.solving.trie;

public class TrieNode {

    private static final int ALPHABET_SIZE = 26;
    private String character;
    private TrieNode[] children;
    private boolean leaf;
    private boolean visited;

    public TrieNode(String character) {
        this.character = character;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public TrieNode getChild(int index){
        return children[index];
    }

    public void setChild(int index, TrieNode node){
        children[index] = node;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "character='" + character + '\'' +
                '}';
    }
}
