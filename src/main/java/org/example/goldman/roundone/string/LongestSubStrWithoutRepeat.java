package org.example.goldman.roundone.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithoutRepeat {

    public static void LongestSubStrWithoutRepeat(){
        String s = "abcab";
        char []chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for(int end=0; end <chars.length; end++){
            char ch = chars[end];
            if(map.containsKey(ch)){
                map.remove(ch);
                start++;
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            max = Math.max(max, end - start + 1);
        }

        System.out.println("Max:: " + max);
    }

    public static void LongestSubStrWithoutKRepeat(){
        String s = "aabcab";
        int k = 2;
        char []chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for(int end=0; end <chars.length; end++){
            char ch = chars[end];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.get(ch) > 2){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) ==0)
                    map.remove(ch);
                start++;
            }
            max = Math.max(max, end - start + 1);
        }

        System.out.println("Max:: " + max);
    }

    public static void main(String[] args) {
        LongestSubStrWithoutKRepeat();
    }
}
