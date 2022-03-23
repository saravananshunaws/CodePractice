package org.example.blackrock.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class LongestSubSequence {
    public static void main(String[] args) {
        int []nums = {100,4,200,1,3,2};

        Arrays.sort(nums);

        int currentSeq = 0;
        int longSeq = 0;
        for(int i=1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                if(nums[i] == nums[i - 1] + 1){
                    currentSeq +=1;
                }else{
                    longSeq = Math.max(longSeq, currentSeq);
                    currentSeq = 1;
                }
            }
        }

        System.out.println(Math.max(currentSeq, longSeq));
    }
}
