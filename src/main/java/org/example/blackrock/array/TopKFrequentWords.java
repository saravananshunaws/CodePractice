package org.example.blackrock.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public static void TopKFrequentWords(String[] array, int k) {
        Map<String, Integer> map = new HashMap<>();

        Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> {
            if (a.getValue() < b.getValue()) {
                return 1;
            } else if (a.getValue() > b.getValue()) {
                return -1;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        };

        for (String str : array) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(comparator);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            q.add(entry);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(q.poll());
        }
    }

    public static void main(String[] args) {
        String[] array = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        TopKFrequentWords(array, k);
    }
}
