package org.example.mustdocoding.heap;

import java.util.*;
import java.math.*;
import java.io.*;

public class TopKFrequentElements {

    public static void usingBucketSort(int []nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > max){
                max = map.get(nums[i]);
            }
        }
        List<Integer>[] bucket = new List[max + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        for(int i= bucket.length -1; i >= 0 && i >= k; i--){
            List<Integer> list = bucket[i];
            System.out.println("Result:: " + list);


        }
    }

    public static void usingPQ(int []nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        for(int i=0; i < pq.size() &&  i < k; i++){
            Map.Entry<Integer, Integer> entry = pq.poll();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int []nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println("Using PQ");
        usingPQ(nums, k);
        System.out.println("Using Bucket");
        usingBucketSort(nums, k);

    }
}
