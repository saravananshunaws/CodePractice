package org.example.meta.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int rotate = 2, n=7;

        for (int i = 0; i < n && i < rotate; i++) {
           int elem = arr[0];
            for (int j = 0; j < n -1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n-1] = elem;
        }

        System.out.println(Arrays.toString(arr));
    }
}
