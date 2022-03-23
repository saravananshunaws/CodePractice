package org.example.mustdocoding.iteration;

import java.util.*;
import java.math.*;
import java.io.*;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int []nums = {1,1,1};
        int k = 2;
        int n = nums.length;
        int currentSum = 0, max = 0, start = 0;
        for (int i = 0; i < n; i++) {
           currentSum += nums[i];
           while (currentSum >= k){
               max = Math.max(max, i-start + 1);
               currentSum -= nums[start];
               start++;
           }
        }

        System.out.println("MAX :: " + max);
    }
}
