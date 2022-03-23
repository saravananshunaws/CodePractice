package org.example.blackrock.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class MoveElementToEnd {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 2, 2, 3, 4, 2};
        int k = 2;
        int readIndex = 0, writeIndex = 0;
        while (readIndex < nums.length) {
            if (nums[readIndex] != k) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        for(int i= writeIndex; i < nums.length; i++){
            nums[i] = k;
        }

        System.out.println(Arrays.toString(nums));
    }
}
