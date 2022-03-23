package org.example.goldman.roundtwo.array;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int []nums = {2, 1, 5, 1, 3, 2};
        int k = 3, max = Integer.MIN_VALUE;
        for(int i=0; i < nums.length-k; i++){
            int currSum = 0;
            for(int j=i; j < i + k; j++){
                currSum += nums[j];
            }
            max = Math.max(max , currSum);
        }

        System.out.println("Max:: " + max);
    }
}
