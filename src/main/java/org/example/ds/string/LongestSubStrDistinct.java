package org.example.ds.string;

import java.util.*;

public class LongestSubStrDistinct {

    public static void findUsingMap( String str){
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0, max= 0;

        for(int windowEnd=0; windowEnd< str.length(); windowEnd++){
            char ch = str.charAt(windowEnd);
            if(map.containsKey(ch)){
                windowStart = Math.max(windowStart, map.get(ch) + 1);
            }

            map.put(ch, windowEnd);
            max = Math.max(max, windowEnd - windowStart + 1);

        }
        System.out.println("Max Using Map:: " + max);
    }

    public static void findUsingArray( String str){
        int []arr = new int[128];
        int left = 0, max = 0;

        for(int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            arr[ch]++;

            if(arr[ch] > 1){
                char leftch = str.charAt(left);
                arr[leftch]--;
                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        System.out.println("Max Using Array:: " + max);
    }

    public static void main(String[] args) {
        String str = "abcaa";
        findUsingArray(str);
        findUsingMap(str);
    }
}
