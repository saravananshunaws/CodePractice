package org.example.blackrock.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class FrequencyStackTest {
    static Map<Integer, Integer> freq = new HashMap<>();
    static Map<Integer, Stack<Integer>> group = new HashMap<>();
    static int maxFreq = 0;

    public static void main(String[] args) {

    }

    public static void push(int data){
         freq.put(data, freq.getOrDefault(data, 0) + 1);
         if(maxFreq < freq.get(data)){
             maxFreq = freq.get(data);
         }

         group.computeIfAbsent(maxFreq, x -> new Stack<>()).push(data);
    }

    public static int pop(){
        int data = group.get(maxFreq).pop();
        freq.put(data, freq.get(data) - 1);
        if( group.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return data;
    }
}
