package org.example.goldman.roundone.array;

import java.util.Arrays;

public class MoveZeroesToLast {
    public static void main(String[] args) {
        int []nums = {0,1,0,3,12};
        int  start = 0;

        for(int end= 0; end < nums.length ; end++){
            if(nums[end] != 0){
                nums[start++] = nums[end];
            }
        }
        for(int i= start; i < nums.length ; i++){
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
