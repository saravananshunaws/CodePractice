package org.example.mustdocoding.arrays;

import java.util.Arrays;

public class RearrangePositiveNegative {
    public static int partition(int[] A) {
        int j = 0;
        int pivot = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < pivot) {
                // swap `A[i]` with `A[j]`
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                j++;
            }
        }
        return j;
    }

    public static void rearrange(int[] A) {
        int p = partition(A);
        for (int n = 0; (p < A.length && n < p); p++, n += 2) {
            // swap `A[n]` with `A[p]`
            int temp = A[n];
            A[n] = A[p];
            A[p] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = {9, -3, 5, -2, -8, -6, 1, 3};

        rearrange(A);

        // print the rearranged array
        System.out.println(Arrays.toString(A));
    }
}
