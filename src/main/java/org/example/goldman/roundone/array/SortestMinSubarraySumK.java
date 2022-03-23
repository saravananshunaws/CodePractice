package org.example.goldman.roundone.array;

public class SortestMinSubarraySumK {
    public static void main(String[] args) {
            int []nums = {3, 4, 1, 1, 6};
            int k = 8;

            int windowStart =0, min = Integer.MAX_VALUE, currSum = 0;
            for(int i = 0; i < nums.length; i++){
                currSum += nums[i];
                while(currSum >= k){
                    min = Math.min(min, i - windowStart + 1);
                    currSum = currSum - nums[windowStart];
                    windowStart++;
                }
            }
        System.out.println("Min:: " + min);
    }
}
