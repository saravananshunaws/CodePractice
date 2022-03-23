package org.example.mustdocoding.string.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonPrefix {
    static class Trie {
        public boolean isLeaf;
        public Map<Character, Trie> children;

        public Trie() {
            isLeaf = false;
            children = new HashMap<>();
        }
    }

    Trie root;

    public void insert(String word) {
        Trie node = root;
        for (Character ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Trie());
            }
            node = node.children.get(ch);
        }
    }

    public String findLCP(List<String> dict) {
        root = new Trie();
        for (String word : dict) {
            insert(word);
        }

        Trie curr = root;
        StringBuffer buffer = new StringBuffer();
        while (curr != null && !curr.isLeaf && curr.children.size() == 1) {
            for (var entry : curr.children.entrySet()) {
                buffer.append(entry.getKey());
                curr = entry.getValue();
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        // given set of keys
        List<String> dict = Arrays.asList("code", "coder", "coding", "codable");
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println("The longest common prefix is " + longestCommonPrefix.findLCP(dict));
    }
}
