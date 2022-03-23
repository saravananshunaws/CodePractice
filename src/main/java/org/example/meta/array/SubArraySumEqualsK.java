package org.example.meta.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        System.out.println("Count :: " + count);
        return count;
    }

    public static void main(String[] args) {
        int []nums = {1,1,1};
        int k = 2;
        subarraySum(nums, k);
    }
}
