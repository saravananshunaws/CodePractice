package org.example.mustdocoding.arrays;

import java.util.Arrays;

public class ProductOfArrayItself {

    public static void findProduct1(int[] arr) {
        int n = arr.length;
        int i, temp = 1;
        int result[] = new int[n];
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }
        temp = 1;
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }
        System.out.println(Arrays.toString(result));
    }

    public static void findProduct(int[] arr) {
        int n = arr.length;
        int lArr[] = new int[n];
        int rArr[] = new int[n];

        lArr[0] = 1;
        for (int i = 1; i < n; i++) {
            lArr[i] = lArr[i - 1] * arr[i - 1];
        }

        rArr[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rArr[i] = rArr[i + 1] * arr[i + 1];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = lArr[i] * rArr[i];
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        findProduct(arr);
        findProduct1(arr);
    }
}
