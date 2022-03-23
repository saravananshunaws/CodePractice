package org.example.mustdocoding.string.trie;

import java.util.*;
import java.math.*;
import java.io.*;

public class WordSquares {
    class TrieNode {
        List<String> startsWith = new ArrayList();
        Map<Character, TrieNode> children = new HashMap();
    }

    private TrieNode root;
    private int len;
    private List<List<String>> answer;

    public List<List<String>> wordSquares(String[] words) {
        len = words[0].length();
        root = new TrieNode();
        answer = new ArrayList();

        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c))
                    curr.children.put(c, new TrieNode());

                curr = curr.children.get(c);
                curr.startsWith.add(word);
            }
        }

        List<String> squares = new ArrayList();
        for (String word : words) {
            squares.add(word);
            search(squares);
            squares.remove(squares.size() - 1);
        }

        return answer;
    }

    private void search(List<String> squares) {
        if (squares.size() == len) {
            answer.add(new ArrayList(squares));
            return;
        }

        int idx = squares.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String word : squares)
            prefixBuilder.append(word.charAt(idx));

        List<String> matches = findByPrefix(prefixBuilder.toString());
        for (String word : matches) {
            squares.add(word);
            search(squares);
            squares.remove(squares.size() - 1);
        }
    }

    private List<String> findByPrefix(String prefix) {
        List<String> matches = new ArrayList();
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c))
                return matches;

            curr = curr.children.get(c);
        }
        matches.addAll(curr.startsWith);
        return matches;
    }

    public static void main(String[] args) {
        String []words = {"area","lead","wall","lady","ball"};
        WordSquares wordSquares = new WordSquares();
        System.out.println(wordSquares.wordSquares(words));
    }
}
