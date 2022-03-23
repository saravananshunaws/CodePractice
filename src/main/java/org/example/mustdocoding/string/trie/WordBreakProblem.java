package org.example.mustdocoding.string.trie;

import java.util.Arrays;
import java.util.List;

public class WordBreakProblem {
    // A class to store a Trie node
    static class Node {
        int CHAR_SIZE = 26;

        boolean exist;
        Node[] next;
        Node() {
            next = new Node[CHAR_SIZE];
            exist = false;
        }
    }

    public static void insertTrie(Node head, String s) {
        Node node = head;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Node();
            }
            node = node.next[c - 'a'];
        }
        node.exist = true;
    }

    public static boolean wordBreak(Node head, String s) {
        boolean[] good = new boolean[s.length() + 1];
        good[0] = true;        // base case

        for (int i = 0; i < s.length(); i++) {
            if (good[i]) {
                Node node = head;
                for (int j = i; j < s.length(); j++) {
                    if (node == null) {
                        break;
                    }
                    node = node.next[s.charAt(j) - 'a'];
                    if (node != null && node.exist) {
                        good[j + 1] = true;
                    }
                }
            }
        }
        return good[s.length()];
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("this", "th", "is", "famous",
                "word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "prob", "lem");

        String s = "wordbreakproblem";
        Node t = new Node();
        for (String word : words) {
            insertTrie(t, word);
        }
        if (wordBreak(t, s)) {
            System.out.println("The string can be segmented");
        } else {
            System.out.println("The string can't be segmented");
        }
    }
}
