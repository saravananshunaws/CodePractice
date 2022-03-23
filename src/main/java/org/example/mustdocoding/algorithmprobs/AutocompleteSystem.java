package org.example.mustdocoding.algorithmprobs;

import java.util.*;

public class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> next;
        Map<String, Integer> count;
        boolean isWord;

        public TrieNode() {
            next = new HashMap<>();
            count = new HashMap<>();
            isWord = false;
        }
    }

    class Pair {
        String str;
        int count;

        public Pair(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String str, int count) {
        char[] chas = str.toCharArray();
        TrieNode node = root;

        for (char c : chas) {
            TrieNode nextNode = node.next.get(c);
            if (nextNode == null) {
                nextNode = new TrieNode();
                node.next.put(c, nextNode);
            }
            node = nextNode;
            node.count.put(str, node.count.getOrDefault(str, 0) + count);
        }

        node.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix = prefix + c;
        TrieNode node = root;
        for (char cc : prefix.toCharArray()) {
            node = node.next.get(cc);
            if (node == null)
                return new ArrayList<>();
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> (o1.count == o2.count ? o1.str.compareTo(o2.str) : o2.count - o1.count));

        for (String str : node.count.keySet()) {
            pq.add(new Pair(str, node.count.get(str)));
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            Pair pair = pq.poll();
            // System.out.println(pair.str + " " + pair.count);
            res.add(pair.str);
        }
        System.out.println("Result:: " + res);
        return res;
    }


    public static void main(String[] args) {
        String[] words = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(words, times);
        autocompleteSystem.input('i');
        autocompleteSystem.input('#');
    }
}