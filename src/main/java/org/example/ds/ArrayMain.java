package org.example.ds;

import java.util.Arrays;

public class ArrayMain {
    public static void main(String[] args) {
        long nums1[] = {1, 3};
        long nums2[] = {2, 5};
        //System.out.println(findMedianSortedArrays(nums1, nums2));
        merge(nums1, nums2, nums1.length, nums2.length);
    }

    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        long[] result = new long[n + m];
        int index = 0;
        int left = 0, right = 0;
        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                result[index] = arr1[left];
                index++;
                left++;
            } else if (arr1[left] >= arr2[right]) {
                result[index] = arr2[right];
                index++;
                right++;
            }
        }
        for (int i = left; i < n; i++) {
            result[index++] = arr1[i];
        }

        for (int i = right; i < m; i++) {
            result[index++] = arr2[i];
        }

        for (int i = right; i < m; i++) {
            //System.out.print();
        }

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int[] merged = new int[nums1.length + nums2.length];
        int left = 0, right = 0, index = 0;

        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] <= nums2[right]) {
                merged[index] = nums1[left];
                left++;
                index++;
            } else if (nums1[left] >= nums2[right]) {
                merged[index] = nums2[right];
                right++;
                index++;
            }
        }

        System.arraycopy(nums1, left, merged, index, nums1.length - left);
        System.arraycopy(nums2, right, merged, index, nums2.length - right);

        Arrays.stream(merged).forEach(System.out::print);

        System.out.println();
        if (merged.length % 2 == 0) {
            double d = (double) (merged[(merged.length / 2) - 1] + merged[merged.length / 2]) / 2;
            System.out.println(d);
            return d;
        } else {
            return merged[merged.length / 2];
        }
    }

}
