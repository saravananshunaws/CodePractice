package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String []strs = {"eat","tea","tan","ate","nat","bat"};
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char []chArr = str.toCharArray();
            Arrays.sort(chArr);
            String str1 = new String(chArr);
            if(!map.containsKey(str1)){
                map.put(str1, new ArrayList<>());
            }
            map.get(str1).add(str);
        }

        System.out.println("Result :: " + map);
    }
}
