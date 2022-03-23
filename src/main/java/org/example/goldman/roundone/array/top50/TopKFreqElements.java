package org.example.goldman.roundone.array.top50;

import java.util.HashMap;
import java.util.*;

public class TopKFreqElements {

    public static void TopKFreqElementsInt(){
        int []nums = {1,1,1,2,2,3};
        int k = 2;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        freq.entrySet().forEach(e -> q.add(e));
        for(int i = 0; i < k; i++){
            System.out.println(q.poll());
        }
    }

    public static void main(String[] args) {

    }
}
