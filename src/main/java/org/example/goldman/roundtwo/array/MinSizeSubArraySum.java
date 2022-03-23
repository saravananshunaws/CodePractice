package org.example.goldman.roundtwo.array;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int []nums = {2, 1, 5, 2, 3, 2};
        int k = 7, min = Integer.MAX_VALUE, currSum = 0, start = 0;
        for(int i=0; i < nums.length; i++){
             currSum += nums[i];
             while(currSum >= k){
                 min = Math.min(min, i - start + 1);
                 currSum= currSum - nums[start];
                 start++;
             }

        }
        System.out.println("Min:: " + min);
    }
}
