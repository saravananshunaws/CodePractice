package org.example.goldman.roundthree.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "aabcckm";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer>  entry: map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println("FirstNonRepeatingChar : " +entry.getKey());
                break;
            }
        }
    }
}
