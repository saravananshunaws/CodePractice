package org.example.blackrock.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class MaxSumSubArrayOfSizeKTest {
    public static void main(String[] args) {
        int []nums = {2, 1, 5, 1, 3, 10};
        int  k = 3, n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i <= n - k; i++){
            int currentSum = 0;
            for(int j = i; j <  i + k; j++){
                currentSum += nums[j];
            }
            max = Math.max(currentSum, max);
        }
        System.out.println("Max:: " + max);
    }
}
