package org.example.slidingwindow;

import java.util.Arrays;

public class MaxSumSubArrayOfSizeK {

    public static void maxSumSubArrayOfSizeK(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        System.out.println("Max Sum" + maxSum);
    }

    public static int findMinSubArray(int[] arr, int S) {
        int windowSum = 0, windowSize = 0, currMin = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowSum >= S) {
                windowSize = (windowEnd - windowStart) + 1;
                if (currMin > 0) {
                    currMin = Math.min(currMin, windowSize);
                } else {
                    currMin = windowSize;
                }
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        System.out.println("Min :: " + currMin);
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 2, 8};
        int k = 8;
        //maxSumSubArrayOfSizeK(nums, 2);
        findMinSubArray(nums, k);
    }
}
