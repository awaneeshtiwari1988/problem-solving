package com.practice.problem.solving.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode("");
    }

    public TrieNode getRoot() {
        return root;
    }

    public void insert(String character){
        TrieNode tempNode = this.root;

        for (int i = 0; i < character.length(); i++) {
            char ch = character.charAt(i);
            int asciiIndex = ch - 'a';
            if(tempNode.getChild(asciiIndex) == null){
                TrieNode trieNode = new TrieNode(String.valueOf(ch));
                tempNode.setChild(asciiIndex,trieNode);
                tempNode = trieNode;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        tempNode.setLeaf(true);
    }

    public boolean search(String key){
        TrieNode tempNode = root;

        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int asciiIndex = ch - 'a';
            if(tempNode.getChild(asciiIndex) == null){
                return false;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        if(!tempNode.isLeaf()){
            return false;
        }

        return true;
    }
}
