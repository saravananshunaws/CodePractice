package org.example.ds.array;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        int n = arr.length;
        int[] lMax = new int[arr.length];
        int[] rMax = new int[arr.length];

        lMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lMax[i] = Math.max(lMax[i - 1], lMax[i]);
        }

        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], rMax[i]);
        }

        System.out.println(Arrays.toString(lMax));
        System.out.println(Arrays.toString(rMax));
        int result = 0;
        for (int j = 0; j < n; j++) {
            result += Math.min(lMax[j], rMax[j]) - arr[j];
        }
        System.out.println("Result:: " + result);
    }
}
