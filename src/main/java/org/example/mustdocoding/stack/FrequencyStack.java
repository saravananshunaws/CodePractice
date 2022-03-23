package org.example.mustdocoding.stack;

import java.util.*;
import java.math.*;
import java.io.*;

public class FrequencyStack {
    static Map<Integer, Integer> freq = new HashMap<>();
    static Map<Integer, Stack<Integer>> group = new HashMap<>();;
    static int maxFreq = 0;

    public static void push(int val){
        int x = freq.getOrDefault(val, 0) + 1;
        freq.put(val, x);
        if(x > maxFreq){
            maxFreq = x;
        }

        group.computeIfAbsent(x, z -> new Stack<>()).push(val);
    }

    public static int pop(){
       int x = group.get(maxFreq).pop();
       freq.put(x, freq.get(x) - 1);
       if(group.get(maxFreq).size() == 0){
           maxFreq--;
       }
       return x;
    }

    public static void main(String[] args) {

    }
}
