package org.example.goldman.roundone.string.top50;

import java.util.HashMap;
import java.util.Map;

public class AreKAnagrams {

    public static void main(String[] args) {
        String str1 = "anagram", str2="grammar";
        int k = 2;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: str1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch: str2.toCharArray()){
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }

        if(map.size() == k){
            System.out.println("K Anagrams");
        }else{
            System.out.println("Not K Anagrams");
        }

    }
}
