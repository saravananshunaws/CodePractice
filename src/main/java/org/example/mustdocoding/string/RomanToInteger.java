package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class RomanToInteger {
    static Map<String, Integer> map = new HashMap();

    static {
        map.put("I" ,1);
        map.put("V",  5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }
    public static void main(String[] args) {
        String s = "MM";
        int carry = 0;
        int result = map.get(s.charAt(0)+"");
        for (int i = 1; i < s.length(); i++) {
            int sum = map.get(s.charAt(i)+"");
            result = sum + result + carry;
            carry = result / 10;
        }

        System.out.println("Result:: " + result);
    }
}
