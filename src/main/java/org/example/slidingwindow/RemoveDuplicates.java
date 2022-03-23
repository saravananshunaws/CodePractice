package org.example.slidingwindow;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void RemoveDuplicates(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        System.out.println();
        Arrays.stream(arr).filter(i -> i != -1).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int []arr = {2, 3, 3, 3, 6, 9, 9};
        RemoveDuplicates(arr);
    }
}
