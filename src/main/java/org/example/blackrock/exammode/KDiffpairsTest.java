package org.example.blackrock.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class KDiffpairsTest {
    public static void main(String[] args) {
        int []nums = {3,1,4,1,5};
        int k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

           if(k > 0 && map.containsKey(entry.getKey() + k)){
               count++;
           } else if(k ==0 && entry.getValue() > 1) {
               count++;
           }
        }

        System.out.println("Result :: " + count);
    }
}
