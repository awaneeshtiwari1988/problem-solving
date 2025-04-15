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

    public boolean search(String key, int index, TrieNode root){
        if (root == null) return false;
        if (index == key.length()) return root.isLeaf();

        char ch = key.charAt(index);
        if (ch == '.') {
            for (TrieNode child : root.getChildren()) {
                if (child != null && search(key, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int asciiIndex = ch - 'a';
            return search(key, index + 1, root.getChild(asciiIndex));
        }
    }

    public String dfs(TrieNode node, String word){
        String result = word;

        for (int i = 0; i < 26; i++) {
            TrieNode tempNode = node.getChild(i);
            if(tempNode != null && tempNode.isLeaf()){
                String childWord = dfs(tempNode, word + (char)(i + 'a'));
                if(childWord.length() > result.length() ||
                        (result.length() == childWord.length() && childWord.compareTo(result) < 0)){
                    result = childWord;
                }
            }
        }

        return result;
    }



}
