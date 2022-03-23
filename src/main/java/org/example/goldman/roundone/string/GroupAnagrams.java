package org.example.goldman.roundone.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            char[] array = list.get(i).toCharArray();
            Arrays.sort(array);
            String s = new String(array);

            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(list.get(i));
        }
        System.out.println("Map:: " + map);
    }
}
