package org.example.bloomberg.explorecard;

import java.util.*;
import java.math.*;
import java.io.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        int []water = {0,1,0,2,1,0,1,3,2,1,2,1};
        int length = water.length;
        int []left = new int[length];
        int []right = new int[length];

        left[0] =  water[0];
        for(int i= 1; i < length; i++){
           left[i] = Math.max(left[i-1], water[i]);
        }

        right[length -1] =  water[length - 1];
        for(int i= length - 2; i >= 0; i--){
            right[i] = Math.max(right[i+1], water[i]);
        }

        int waterCount = 0;
        for(int i= 0; i < length; i++){
            waterCount +=  Math.min(left[i], right[i]) - water[i];
        }
        System.out.println("Water :: " + waterCount);
    }
}
