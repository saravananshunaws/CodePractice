package org.example.goldman.roundthree.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0, max = Integer.MIN_VALUE;
        char[] array = str.toCharArray();
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            map.put(array[windowEnd], map.getOrDefault(array[windowEnd], 0) + 1);
            if (map.size() > k) {
                map.put(array[windowEnd], map.get(array[windowEnd]) - 1);
                windowStart++;
                if (map.get(array[windowEnd]) == 0) {
                    map.remove(array[windowEnd]);
                }
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        System.out.println("Max :: " + max);
    }
}
