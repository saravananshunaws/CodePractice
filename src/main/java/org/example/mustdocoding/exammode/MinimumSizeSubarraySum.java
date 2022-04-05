package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
        int target = 7;
        int []nums = {1,4,4};

        int n = nums.length, start = 0, currentSum = 0, currentMax = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            while(currentSum >= target){
                currentSum -= nums[start++];
                currentMax = Math.min(currentMax, i-start + 1);
            }
        }
        System.out.println("Current Min :: " + currentMax);
    }
}
