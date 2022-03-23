package org.example.mustdocoding.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordSearch2 {
    static Trie root = new Trie();

    static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        boolean isword = false;
        String word;
    }

    public static void insert(String[] words) {
        Trie node = root;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new Trie());
                }

                node = node.children.get(ch);
            }
            node.isword = true;
            node.word = word;
        }
    }


    public static void search(String[][] board, String[] words) {
        insert(words);
        int m = board.length;
        int n = board[0].length;
        Set<String> result = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backTracking(board, words, m, n, i, j, result, root);
            }
        }
        System.out.println("Result :: " + result);

    }

    public static void backTracking(String[][] board, String[] words, int m, int n, int i, int j, Set<String> result, Trie root) {
        if (i < 0 || i >= m || j < 0 || j >= n ) {
            return;
        }

        String ch = board[i][j];
        Trie child = root.children.get(ch.charAt(0));
        System.out.println(ch + "-" + root.children.get(ch.charAt(0)));
        if(child == null){
            return;
        }

        if (root.children.get(ch.charAt(0)).isword) {
            result.add(root.children.get(ch.charAt(0)).word);
        }

        board[i][j] = "*";

        backTracking(board, words, m, n, i + 1, j, result, child);
        backTracking(board, words, m, n, i - 1, j, result, child);
        backTracking(board, words, m, n, i, j + 1, result, child);
        backTracking(board, words, m, n, i, j - 1, result, child);

        board[i][j] = ch;
    }

    public static void main(String[] args) {
        String[][] board = {{"o", "a", "a", "n"}, {"e", "t", "a", "e"}, {"i", "h", "k", "r"}, {"i", "f", "l", "v"}};
        String[] words = {"oath", "pea", "eat", "rain"};
        search(board, words);
    }
}
