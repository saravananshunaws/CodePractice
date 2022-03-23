package org.example.goldman.roundthree.array;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int []nums = {2, 1, 5, 1, 3, 2};
        int k = 3, n = nums.length;
        int maxSum = 0, currSum = 0;
        for(int i=0; i < n - k; i++){
            currSum = 0;
            for(int j=i; j <  i + k; j++){
                currSum += nums[j];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("Max :: " + maxSum) ;
    }
}
