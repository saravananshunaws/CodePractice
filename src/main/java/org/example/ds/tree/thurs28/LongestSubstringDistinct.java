package org.example.ds.tree.thurs28;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringDistinct {

    public static void array(String str){
        int []array = new int[128];
        int left = 0, max = 0;

        for(int right=0; right < str.length(); right++){
            char ch = str.charAt(right);
            array[ch]++;

            while(array[ch] > 1){
                char leftCh = str.charAt(left);
                array[leftCh]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println("Max:: " + max);
    }

    public static void map(String str){
        int max = 0, windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int windowEnd=0; windowEnd < str.length(); windowEnd++){
           char ch = str.charAt(windowEnd);
           if(map.containsKey(ch)){
               windowStart = Math.max(windowStart, map.get(ch) + 1);
           }
           map.put(ch, windowEnd);
           max = Math.max(max, windowEnd - windowStart + 1);
        }
        System.out.println("Max:: " + max);
    }

    public static void mapKDistinct(String str, int k){
        int max = 0, windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int windowEnd=0; windowEnd < str.length(); windowEnd++){
            char ch = str.charAt(windowEnd);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.size() > k){
                char chTemp = str.charAt(windowStart);
                map.put(chTemp, map.get(chTemp) -1);
                if(map.get(chTemp) == 0){
                    map.remove(chTemp);
                }
                windowStart++;
            }
           // map.put(ch, windowEnd);
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        System.out.println("mapKDistinct Max:: " + max);
    }

    public static void main(String[] args) {
        String str = "abcdabb";
         array(str);
        System.out.println();
        mapKDistinct("aaabcdac", 2);
    }
}
