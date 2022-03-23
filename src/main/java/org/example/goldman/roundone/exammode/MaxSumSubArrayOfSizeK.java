package org.example.goldman.roundone.exammode;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int []arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int n = arr.length;
        int windowSum = 0, maxSum = 0;
        for(int i=0; i < n - k; i++){
            windowSum = 0;
            for(int j=i; j < i + k; j++){
                windowSum += arr[j];
            }
            maxSum = Math.max(windowSum, maxSum);
        }
        System.out.println("Max Sum:: " + maxSum);
    }
}
