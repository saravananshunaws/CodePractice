package org.example.ds.array;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int []nums = new int[] { 2, 1, 5, 1, 3, 2 };
        int k = 7;

        int windowStart = 0, currSum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i]; 
            while(currSum >= k){
                currSum = currSum - nums[windowStart];
                min = Math.min(min , i - windowStart + 1 );
                windowStart++;
            }
        }
        System.out.println("Min:: " + min);
    }
}
