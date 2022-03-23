package org.example.mustdocoding.iteration;

import java.util.*;
import java.math.*;
import java.io.*;

public class KDiffPairs {
    public static void main(String[] args) {
        int []nums = {3,1,4,1,5};
        int k = 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0 ) + 1);
        }

        int count =0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
           int key = entry.getKey();
           int value = entry.getValue();
           if(k > 0 && map.containsKey(key - k)){
               count++;
           } else if(k ==0 && value > 1){
               count++;
           }
        }
        System.out.println("Count :: " + count);
    }
}
