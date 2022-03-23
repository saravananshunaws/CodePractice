package org.example.blackrock.array;

import java.util.*;

public class TopKFrequentElementsBucket {

    public static void  TopKFrequentElementsBucket(int[] arr, int k){

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
            max = Math.max(max, map.get(arr[i]));
        }

        List<List<Integer>> buckets = new ArrayList<>(Collections.nCopies(max + 1, null));
        /*for (int i = 0; i < max + 1; i++) {
            buckets.add(null);
        }*/
        for (int i : map.keySet()) {
            int freq = map.get(i);
            if(buckets.get(freq) == null){
                buckets.add(freq,  new ArrayList());
            }
            buckets.get(freq).add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = buckets.size() -1; i >= 0 && result.size() < k; i--) {
            if(buckets.get(i) != null) {
                result.add(buckets.get(i));
            }
        }

        System.out.println("Result::  " + result);

    }

    public static void  TopKFrequentElementsMap(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int i : map.keySet()) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length && result.size() < k; i++) {
            result.add(queue.poll());
        }

        System.out.println("Result::  " + result);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 2, 4, 5, 10, 10};
        int k = 2;
       // TopKFrequentElementsMap(arr, k);
        TopKFrequentElementsBucket(arr, k);
    }
}
