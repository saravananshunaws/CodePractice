package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class TestTrappingRainWater {
    public static void main(String[] args) {
        int []height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = height.length;
        int []lArr = new int[n];
        int []rArr = new int[n];

        lArr[0] = height[0];
        for (int i = 1; i < n; i++) {
            lArr[i] = Math.max(lArr[i-1], height[i]);
        }

        rArr[n-1] = height[n-1];
        for (int i = n-2; i >=0  ; i--) {
            rArr[i] = Math.max(rArr[i+1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(lArr[i], rArr[i]) - height[i];
        }

        System.out.println("Water :: " + water);
    }
}
