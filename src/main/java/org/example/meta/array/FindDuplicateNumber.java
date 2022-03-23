package org.example.meta.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int [] nums = {1,3,4,2,2};
        int left =0, right = nums.length -1;
        int n = nums.length;
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid < n && mid > 0 && (nums[mid] == nums[mid + 1] || nums[mid] == nums[mid -1])){
                System.out.println(nums[mid]);
                break;
            }else {

            }
        }
    }
}
