package org.example.goldman.roundtwo.string;

import java.util.*;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String str ="araaci";
        int k = 2, windowStart = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        char []array = str.toCharArray();

        for(int i=0; i < array.length; i++){
           map.put(array[i], map.getOrDefault(array[i], 0) + 1);
           if(map.size() > k){
               map.put(array[i], map.get(array[windowStart])  - 1);
               if(map.get(array[i]) == 0){
                   map.remove(array[i]);
               }
               windowStart++;
           }
           max = Math.max(max, i - windowStart + 1);
        }
        System.out.println("Max:: " + max);
    }
}
