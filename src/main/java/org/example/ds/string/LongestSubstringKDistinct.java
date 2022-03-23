package org.example.ds.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        int windowStart = 0, max = 0;
        char []chArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < chArr.length; i++){
            char ch = chArr[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k){
               char chTemp = chArr[windowStart];
               map.put(chTemp, map.get(chTemp) -1);
               if(map.get(chTemp)  == 0){
                   map.remove(chTemp);
               }
               windowStart++;
            }
            max = Math.max(max, i - windowStart + 1);
        }
        System.out.println("Max :: " + max);
    }
}
