package org.example.blackrock.topicwise.binarysearch;

import java.util.*;
import java.math.*;
import java.io.*;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int []nums = {4,5,6,7,0,1,2};
        int target = 0;
        int start = 0, end = nums.length -1;
        while(start <= end){
            int mid = (start + end) / 2;

            if(nums[mid] == target){
                System.out.println("Index :: " + mid);
                return;
            } else if(nums[mid] >= nums[start] ){
                 if(target >= nums[start] && target < nums[mid]){
                     end = mid - 1;
                 }else{
                     start = mid + 1;
                 }
            } else{
                if(target >= nums[mid] && target < nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
    }
}
