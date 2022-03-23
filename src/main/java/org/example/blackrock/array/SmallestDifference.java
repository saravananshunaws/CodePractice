package org.example.blackrock.array;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        smallestDifference(arrayOne, arrayTwo);
    }

    public static void smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int min = Integer.MAX_VALUE;
        int result[] = new int[2];
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int value = Math.abs(arrayOne[i] - arrayTwo[j]);
                if (value < min) {
                    result[0] = i;
                    result[1] = j;
                    min = value;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
}

