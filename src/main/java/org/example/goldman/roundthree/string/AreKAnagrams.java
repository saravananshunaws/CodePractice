package org.example.goldman.roundthree.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreKAnagrams {
    public static void main(String[] args) {
        String str1 = "fodr", str2="gork";
        int k = 2;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < str1.length(); i++){
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i),  0) + 1);
        }

        List<Character> list = new ArrayList<>();
        for(int i=0; i < str2.length(); i++){
            char ch = str2.charAt(i);
            if(map.containsKey(ch)){
                map.remove(ch);
            }else{
                list.add(str2.charAt(i));
            }
        }

        if(list.size() == k){
            System.out.println("K Anagarms");;
        }else{
            System.out.println("Not K Anagarms");;
        }
    }
}
