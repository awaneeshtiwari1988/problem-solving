package com.practice.problem.solving.trie;

public class LongestWord {

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        return trie.dfs(trie.getRoot(), "");
    }

    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        LongestWord longestWord = new LongestWord();
        System.out.println(longestWord.longestWord(words));
    }
}
