package org.example.mustdocoding.string.trie;

import java.util.HashMap;
import java.util.Map;

public class AddBoldTagInString {
    TrieNode root;

    static class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
    }


    public AddBoldTagInString() {
        root = new TrieNode();
    }

    public void buildTrie(String s, String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (Character ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }

            node.isWord = true;
        }
    }

    public int search(String s, int i, int len) {
        int end = -1;
        TrieNode node = root;
        while (i < len){
            Character ch = s.charAt(i);
            if(!node.children.containsKey(ch)){
                return end;
            }
            node = node.children.get(ch);
            if(node.isWord){
                end = i;
            }
            i++;
        }
        return end;
    }

    public void addBoldTagInString(String s, String[] words) {
        buildTrie(s, words);
        int len = s.length(), maxEnd = -1;
        boolean[] isBold = new boolean[len];
        for (int i = 0; i < len; i++) {
            int end = search(s, i, len);
            maxEnd = Math.max(maxEnd, end);
            isBold[i] = maxEnd >= i;
        }
        StringBuilder sb = new StringBuilder();
        boolean state = false;
        for (int i = 0; i < len; ++ i) {
            if (isBold[i] != state) {
                state = !state;
                if (state) {
                    sb.append("<b>");
                } else {
                    sb.append("</b>");
                }
            }
            sb.append(s.charAt(i));
        }
        if (state) {
            sb.append("</b>");
        }

        System.out.println("Bold String :: " + sb);
    }

    public static void main(String[] args) {
        AddBoldTagInString add = new AddBoldTagInString();
        String s = "abcxyz123";
        String[] words = {"abc", "123"};
        add.addBoldTagInString(s, words);
    }
}
