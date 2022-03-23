package org.example.mustdocoding.string.trie;

import java.util.*;
import java.math.*;
import java.io.*;

public class DesignAutoCompleteSystem {

    static class Sentence {
        String s;
        int hottness;
        Sentence(String s, int hottness) {
            this.s = s;
            this.hottness = hottness;
        }
    }

    static class TrieTree {
        HashMap<Character, TrieTree> map;
        HashMap<String, Sentence> sentences;
        TrieTree() {
            map = new HashMap<>();
            sentences = new HashMap<>();
        }
    }

    StringBuilder sb;
    final TrieTree root;

    public DesignAutoCompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        root = new TrieTree();
        for(int i =0; i<sentences.length; i++) {
            buildTree(sentences[i], times[i]);
        }
    }


    void buildTree(String sentence, int times) {
        TrieTree node = root;
        for(char c: sentence.toCharArray()) {
            if(!node.map.containsKey(c)) {
                TrieTree newTrieTree = new TrieTree();
                node.map.put(c, newTrieTree);
                node = newTrieTree;
            } else {
                node = node.map.get(c);
            }

            if(node.sentences.containsKey(sentence)) {
                Sentence sentenceVal = node.sentences.get(sentence);
                sentenceVal.hottness += times;
                node.sentences.put(sentence, sentenceVal);
            } else {
                Sentence newSentence = new Sentence(sentence, times);
                node.sentences.put(sentence, newSentence);
            }
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            buildTree(sb.toString(), 1);
            sb = new StringBuilder();
            return new ArrayList<>();
        }
        sb.append(c);
        return searchSentence(sb.toString());

    }


    List<String> searchSentence(String sentence) {
        TrieTree node = root;
        for(char c: sentence.toCharArray()) {
            if(!node.map.containsKey(c)) {
                return new ArrayList<>();
            }
            node = node.map.get(c);
        }

        PriorityQueue<Sentence> pq = new PriorityQueue<>((a,b) -> {
            if(a.hottness == b.hottness) {
                return a.s.compareTo(b.s);
            }
            if(a.hottness<b.hottness) {
                return 1;
            }
            return -1;
        });

        for(Map.Entry<String,Sentence> sent: node.sentences.entrySet()) {
            pq.add(sent.getValue());
        }

        int counter = 0;
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty() && counter<3) {
            ans.add(pq.poll().s);
            counter++;
        }

        return ans;
    }

    public static void main(String[] args) {
        DesignAutoCompleteSystem autoCompleteSystem = new DesignAutoCompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 2, 2});
        System.out.println(autoCompleteSystem.input('i'));
    }
}
