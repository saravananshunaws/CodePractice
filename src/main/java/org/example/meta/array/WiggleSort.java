package org.example.meta.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class WiggleSort {
    public static void main(String[] args) {
        int []nums = {1,5,1,1,6,4};
        int []res = new int[nums.length];
        Arrays.sort(nums);
        int i = 1, j= nums.length -1;
        while(i < nums.length ){
            res[i] = nums[j];
            j--; i+=2;
        }
        i = 0;
        while(i < nums.length ){
            res[i] = nums[j];
            j--; i+=2;
        }

        System.out.println(Arrays.toString(res));
    }
}
