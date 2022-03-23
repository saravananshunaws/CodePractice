package org.example.meta.exercise;

import java.util.*;

public class MaximumAverageSubArray {

    static class Subarray {
        int left;
        int right;
        public Subarray(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString(){
            int[] arr = new int[] {left, right};
            return Arrays.toString(arr);
        }
    }

    private static Subarray[] aboveAverageSubarrays(int[] arr) {
        Queue<Subarray> queue =
                new PriorityQueue<>((s1, s2) -> s1.left == s2.left ? s1.right - s2.right : s1.left - s2.left);

        int totalSum = Arrays.stream(arr).sum();
        System.out.println(totalSum);
        int n = arr.length;

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += arr[j];

                float average1 = (float)sum/(j-i+1);
                float average2 = ((j-i+1) == n) ? Integer.MIN_VALUE : (float)(totalSum-sum)/(n-(j-i+1));
                System.out.println(average1 + ", " + average2);
                if(average1 > average2) {
                    queue.offer(new Subarray(i+1, j+1));
                }
            }
        }
        System.out.println(queue);
        return queue.toArray(new Subarray[0]);
    }

    static Subarray[] aboveAverageSubarrays1(int[] arr) {
        List<Subarray> resultList = new ArrayList<>();
        int totalSum = 0;
        for (int k : arr) {
            totalSum += k;
        }
        for (int i = 0; i < arr.length; i++) {
            int sumCurrent = 0;
            for (int j = i; j < arr.length; j++) {
                sumCurrent += arr[j];
                if (sumCurrent / (j - i + 1) > (totalSum - sumCurrent) / (arr.length  - (j - i + 1))) {
                    resultList.add(new Subarray(i + 1, j + 1));
                }
            }
        }
        return resultList.toArray(new Subarray[0]);
    }


    public static void main(String[] args) {
        int []A = {3, 4, 2};
        System.out.println( aboveAverageSubarrays(A));
        System.out.println( aboveAverageSubarrays1(A));
    }
}
