package com.practice.problem.solving.trie;

public class TestTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("air");
        trie.insert("apple");
        trie.insert("approve");
        trie.insert("bee");

        System.out.println(trie.search("bee"));
    }
}
