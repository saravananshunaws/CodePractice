package org.example.meta.array;

import java.util.Arrays;

public class ProductArrayExceptItself {
    public static void usingDivision (int []nums, int n){
        int left[] = new int[n];
        int overall = 1;
        for (int i = 0; i < n; i++) {
            overall *= nums[i];
        }
        System.out.println("OverAll " + overall);

        for (int i = 0; i < n; i++) {
            System.out.print((overall / nums[i]) + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 6, 2};
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1]; // store the product till just previous index
        }

        right[n - 1] = 1;//initialzie the first element as 1
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1]; //store the product till just next index
        }

        for (int i = 0; i < n; i++) {
            System.out.print ((left[i] * right[i]) + " ");
        }
        System.out.println();
        usingDivision(nums, n);
    }
}
