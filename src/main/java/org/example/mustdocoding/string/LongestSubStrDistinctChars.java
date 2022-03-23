package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class LongestSubStrDistinctChars {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0, max = 0;
        char []array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
          char ch = array[i];
          if(map.containsKey(ch)){
            /*  char tempCh = array[windowStart];
              windowStart++;
              map.put(tempCh, map.get(tempCh) - 1);
              if(map.get(tempCh) == 0){
                  map.remove(tempCh);
              }*/
              map.remove(ch);
              windowStart++;
          }
          map.put(ch, map.getOrDefault(ch, 0) + 1);
          max = Math.max(max, i - windowStart  + 1);
        }

        System.out.println("Max :: " + max);
    }
}
