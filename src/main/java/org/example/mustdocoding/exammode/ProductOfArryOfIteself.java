package org.example.mustdocoding.exammode;

import java.util.Arrays;

public class ProductOfArryOfIteself {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = nums.length;
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(product/ nums[i]);
        }
        int []lArr = new int[n];
        int []rArr = new int[n];

        lArr[0] = 1;
        for (int i = 1; i < n; i++) {
             lArr[i] = lArr[i-1] * nums[i-1];
        }

        rArr[n-1] = 1;
        for (int i = n-2; i >= 0 ; i--) {
            rArr[i] = rArr[i+1] * nums[i+1];
        }

        System.out.println(Arrays.toString(lArr));
        System.out.println(Arrays.toString(rArr));
    }
}

