package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class PeakElement {
    public static void main(String[] args) {
        int []nums = {1,2,3,1};
        int n = nums.length, currentPeakElement = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }

        System.out.println("currentPeakElement ::  "+ l);
    }
}
