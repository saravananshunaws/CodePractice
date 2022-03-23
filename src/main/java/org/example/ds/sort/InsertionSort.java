package org.example.ds.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int []nums = {10,20,40,5,15,60};

        for(int i=1; i < nums.length; i++){
            for(int j=i; j > 0; j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
