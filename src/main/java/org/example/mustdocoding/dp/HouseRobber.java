package org.example.mustdocoding.dp;

import java.util.*;
import java.math.*;
import java.io.*;

public class HouseRobber {
    public static void main(String[] args) {
        int []nums = {1,2,3,1};
    }

    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        int[] maxRobbedAmount = new int[nums.length + 1];
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        }
        return maxRobbedAmount[0];
    }
}
