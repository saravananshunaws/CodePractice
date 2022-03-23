package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class Subsets {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int i=0; i < nums.length; i++){
            int size = output.size();
            for(int j=0; j < size; j++){
                List<Integer> list = new ArrayList<>(output.get(i));
                list.add(nums[i]);
                output.add(list);
            }
        }

        System.out.println("Result:: " + output);
    }
}
