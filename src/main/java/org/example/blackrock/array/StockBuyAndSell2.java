package org.example.blackrock.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class StockBuyAndSell2 {
    public static void main(String[] args) {
        int []nums = {7,1,5,3,6,4};
        int peak = nums[0];
        int valley = nums[0];
        int i = 0, profit = 0;
        while(i < nums.length - 1){
            while(i < nums.length -1 && nums[i] >= nums[i+1])
                i++;

            valley = nums[i];

            while(i < nums.length -1 && nums[i] <= nums[i+1])
                i++;

            peak = nums[i];
            profit += peak - valley;
        }

        System.out.println("Profit :: " + profit);
        profit = 0;
        for(int j=1; j < nums.length; j++){
            if(nums[j] > nums[j-1]){
                profit += nums[j] - nums[j -1];
            }
        }

        System.out.println("Profit II :: " + profit);
    }
}
