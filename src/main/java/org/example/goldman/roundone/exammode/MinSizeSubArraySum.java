package org.example.goldman.roundone.exammode;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 2, 8};
        int S = 7;
        int windowStart = 0, windowSum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            while(windowSum >= S){
                min = Math.min(windowSum, min);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
    }
}
