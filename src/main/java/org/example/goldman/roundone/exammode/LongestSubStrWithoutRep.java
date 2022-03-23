package org.example.goldman.roundone.exammode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithoutRep {

    public static void findUsingMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0, max = 0;
        for(int windowEnd =0; windowEnd < str.length(); windowEnd++){
            char ch = str.charAt(windowEnd);
            if(map.containsKey(ch)){
                windowStart = Math.max(windowStart, map.get(ch) + 1);
            }

            map.put(ch, windowEnd);
            max = Math.max(max, windowEnd - windowStart + 1);

        }
    }

    public static void main(String[] args) {
        String str = "abcaa";
        //findUsingArray(str);
        findUsingMap(str);
    }
}
