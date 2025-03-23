package com.practice.problem.solving.trie;

import java.util.ArrayList;
import java.util.List;

public class WordFinder {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();

        for(String word : words){
            trie.insert(word);
        }

        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                dfs(board, i, j , "",trie.getRoot(), visited, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, String path, TrieNode root, boolean[][] visited, List<String> result) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]){
            return;
        }

        char ch = board[i][j];
        int asciiCode = ch - 'a';
        TrieNode node = root.getChild(asciiCode);

        if(node == null){
            return;
        }

        path += ch;
        if(node.isLeaf()){
            result.add(path);
            node.setLeaf(false);
        }

        visited[i][j] = true;

        dfs(board, i+1, j, path, node, visited, result);
        dfs(board, i-1, j, path, node, visited, result);
        dfs(board, i, j+1, path, node, visited, result);
        dfs(board, i, j-1, path, node, visited, result);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        WordFinder wordFinder = new WordFinder();
        System.out.println(wordFinder.findWords(board,words));
    }
}
