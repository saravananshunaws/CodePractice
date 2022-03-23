package org.example.blackrock.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class SearchRotatedSortedArrayTest {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        int start =0, end = nums.length -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                System.out.println("Target Found :: " + mid);
                return;
            } else if(nums[mid] >= nums[start]){
                if(target < nums[mid] && target > nums[start]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            } else{
                if(target > nums[mid] && target < nums[start]){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }
            }
        }
    }
}
