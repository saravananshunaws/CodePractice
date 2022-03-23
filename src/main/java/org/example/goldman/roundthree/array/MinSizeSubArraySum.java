package org.example.goldman.roundthree.array;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 1, 6};
        int S = 8, n = nums.length;
        int windowSum = 0, min = Integer.MAX_VALUE, start =0;
        for (int i = 0; i < n; i++) {
            windowSum += nums[i];
            while(windowSum >= S){
                min = Math.min(min, i-start + 1);
                windowSum -= nums[start];
                start++;
            }
        }
        System.out.println("Min :: " + min);
    }
}
