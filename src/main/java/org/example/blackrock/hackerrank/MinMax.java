package org.example.blackrock.hackerrank;

import java.util.Arrays;
import java.util.List;

public class MinMax {

    public static void miniMaxSum(List<Integer> arr) {
        int k = 4, n = arr.size();
        int currentSum = 0, max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for(int i=0; i < n; i++){
            currentSum = 0;
            for(int j=0; j < n; j++){
                if(i != j)
                    currentSum += arr.get(j);
            }
            max = Math.max(max, currentSum);
            min = Math.min(min, currentSum);
        }
        System.out.println(min);
        System.out.println(max);
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5};
        miniMaxSum(Arrays.asList(1,2,3,4,5));
    }
}
