package org.example.mustdocoding.string.trie;

import java.util.*;
import java.math.*;
import java.io.*;

public class Trie {
    boolean isLeaf;
    Map<Character, Trie> children;

    public Trie(){
        isLeaf = false;
        children = new HashMap<>();
    }

    public void add(String str){
        Trie curr = this;
        for (Character ch:  str.toCharArray()) {
            curr.children.putIfAbsent(ch, new Trie());
            curr = curr.children.get(ch);
        }

        curr.isLeaf = true;
    }

    public boolean search(String key){
        System.out.println("Searching Key:: " + key);
        Trie curr = this;
        for (Character ch : key.toCharArray()) {
            curr = curr.children.get(ch);
            if(curr == null){
                return false;
            }
        }
        return curr.isLeaf;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("trie");
        System.out.println(trie.search("test"));
    }
}
