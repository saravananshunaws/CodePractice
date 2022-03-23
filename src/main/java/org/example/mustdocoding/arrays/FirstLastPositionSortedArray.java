package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class FirstLastPositionSortedArray {

    public static int search(int[] nums, int target, boolean isFirstPass){
        int left = 0, right = nums.length -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                int firstIndex = mid;
                if(isFirstPass){
                    while(nums[mid] == nums[mid-1]){
                        firstIndex = mid -1;
                        mid--;
                    }
                    return firstIndex;
                }else{
                    while(nums[mid] == nums[mid+1]){
                        firstIndex = mid+1;
                        mid++;
                    }
                    return firstIndex;
                }
            } else if(target <= nums[mid]){
                right = mid - 1;
            } else if(target >= nums[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];

        int leftIndex =  search(nums, target, true);
        result[0] = leftIndex;

        leftIndex =  search(nums, target, false);
        result[1] = leftIndex;

        return result;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        int []result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
