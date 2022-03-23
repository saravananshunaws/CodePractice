package org.example.blackrock.stack;

import java.util.*;
import java.math.*;
import java.io.*;

public class FrequencyStack {
    static Map<Integer, Integer> freq = new HashMap<>();
    static Map<Integer, Stack<Integer>> group = new HashMap<>();
    static int maxFreq = 0;

    public static void push(int data){
        freq.put(data, freq.getOrDefault(data, 0 ) + 1);
        int freqVal = freq.get(data);
        if(freqVal > maxFreq){
            maxFreq = freqVal;
        }

        group.computeIfAbsent(freqVal, x -> new Stack<Integer>()).push(data);

    }

    public static int pop(){

        return 0;
    }

    public static void main(String[] args) {

    }
}
