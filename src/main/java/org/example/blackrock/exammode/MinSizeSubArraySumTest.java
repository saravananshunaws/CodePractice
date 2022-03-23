package org.example.blackrock.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinSizeSubArraySumTest {
    public static void main(String[] args) {
        int []nums = {2, 1,5,2,3,2};
        int k = 7, n = nums.length;
        int minSum = Integer.MAX_VALUE, currentSum = 0, window = 0;
        for(int  i =0; i < n; i++){
            currentSum += nums[i];
            while(currentSum >= k){
                minSum = Math.min(minSum, i - window + 1);
                currentSum -= nums[window];
                window++;
            }
        }

        System.out.println("Max Sum:: " + minSum);
    }
}
