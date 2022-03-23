package org.example.goldman.roundone.array.top50;

import java.util.*;

public class TopKFrequentElementsBucket {

    public static void  TopKFrequentElementsBucket(int[] arr, int k){

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
            max = Math.max(max, map.get(arr[i]));
        }

        List<Integer>[] buckets = new List[max+1];
        for (int i : map.keySet()) {
            int freq = map.get(i);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList();
            }
            buckets[freq].add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = buckets.length -1; i >= 0 && result.size() < k; i--) {
            if(buckets[i] != null) {
                result.add(buckets[i]);
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
