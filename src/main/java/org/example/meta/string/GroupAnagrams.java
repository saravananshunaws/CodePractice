package org.example.meta.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = String.valueOf(array);
            if (!result.containsKey(sorted)) {
                result.computeIfAbsent(sorted, z -> new ArrayList<>()).add(str);
            } else {
                result.get(sorted).add(str);
            }
        }

        System.out.println("Result :: " + result);
    }
}
