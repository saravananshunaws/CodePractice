package org.example.mustdocoding.string;

import java.util.Arrays;
import java.util.Comparator;

public class FormLargestNumberFromList {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = (a, b) -> {
            String first = a + b;
            String second = b + a;
            return second.compareTo(first);
        };

        Arrays.sort(asStrs, comparator);
        String str = "";
        for (String i : asStrs) {
            str += i;
        }
        System.out.println("Result :: " + str);
    }
}
