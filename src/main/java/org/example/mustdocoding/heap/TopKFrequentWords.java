package org.example.mustdocoding.heap;

import java.util.*;
import java.math.*;
import java.io.*;

public class TopKFrequentWords {

    public static void TopKFrequentWords( String []words, int k){
        Map<String, Integer> map = new HashMap<>();
        for(String str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator = (e1, e2) -> {
           if(e2.getValue() > e1.getValue()){
               return 1;
           }else if(e1.getValue() < e2.getValue()){
               return -1;
           }else{
               return e1.getKey().compareTo(e2.getKey());
           }
        };

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(comparator);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
               q.add(entry);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(q.poll());
        }
    }

    public static void main(String[] args) {
        String []words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        TopKFrequentWords(words, k);
    }
}
