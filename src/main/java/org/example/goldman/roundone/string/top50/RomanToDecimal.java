package org.example.goldman.roundone.string.top50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RomanToDecimal {
    private static Map<String , Integer> map = new HashMap();

    static{
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("I", 1);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public static void romanToDecimal(String s){
        int sum = 0;
        char []chArray = s.toCharArray();
        for(char ch : chArray){
            sum += map.get(String.valueOf(ch));
        }
        System.out.println("Sum :: " + sum);
    }

    public static void main(String[] args) {
        romanToDecimal("III");
    }
}
