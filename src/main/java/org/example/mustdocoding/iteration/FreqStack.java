package org.example.mustdocoding.iteration;

import java.util.*;
import java.math.*;
import java.io.*;

public class FreqStack {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Stack<Integer>> group = new HashMap<>();
    int maxValue = 0;
    public FreqStack() {
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int freqVal = freq.get(val);
        if(freqVal > maxValue){
            maxValue = freqVal;
        }
        group.computeIfAbsent(freqVal, z -> new Stack<>()).push(val);
    }

    public int pop() {
        int freqVal = group.get(maxValue).pop();
        freq.put(freqVal, freq.getOrDefault(freqVal, 0) - 1);
        if(group.get(maxValue).size() == 0 ){
            maxValue--;
        }
        return freqVal;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(5);
        freqStack.push(7);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
