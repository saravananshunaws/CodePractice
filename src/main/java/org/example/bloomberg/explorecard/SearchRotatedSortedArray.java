package org.example.bloomberg.explorecard;

import java.util.*;
import java.math.*;
import java.io.*;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int []nums = {4,5,6,7,0,1,2};
        int target = 4;

        int low =0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                System.out.println("Index Found:: " + mid);
                return;
            } else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                } else{
                    low = mid + 1;
                }
            } else{
                if(target >= nums[mid] && target < nums[high]){
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }
            }
        }
    }
}
