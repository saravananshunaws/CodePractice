package org.example.mustdocoding.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKHeapProblems {

    public static void kthLargestElement(){
        int []nums = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }

        System.out.println("Kth Largest Element ::" + pq.peek());
    }

    public static void TopKFrequentElement(){
        int []nums  = {1,1,1,2,2,3};
        int k = 2;
        Map<Integer, Integer> freq = new HashMap<>();
        Comparator<Map.Entry<Integer, Integer>> comparator = (m1, m2) -> Integer.compare(m2.getValue(), m1.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) +  1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(entry);
        }

        int size = pq.size();
        for (int i = 0; i < size && i < k ; i++) {
            System.out.println(pq.poll().getKey());
        }
    }

    public static void main(String[] args) {
        TopKFrequentElement();
        kthLargestElement();
    }
}
