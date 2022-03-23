package org.example.goldman.roundone.array.top50;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RearrangeArraySmallestLargest {
    public static void main(String[] args) {
        int []nums = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int []tempArr = new int[nums.length];
        int  n = nums.length -1, index = 0;
        for(int i = 0, j = n; i < n /2 || j > n/2; i++,j--){
            if(index < n){
                tempArr[index] = nums[i];
                index++;
            }

            if(index < n){
                tempArr[index] = nums[j];
                index++;
            }
        }
        System.out.println(Arrays.toString(tempArr));
    }
}
