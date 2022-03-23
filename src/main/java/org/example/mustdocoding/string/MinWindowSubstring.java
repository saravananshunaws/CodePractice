package org.example.mustdocoding.string;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    private static boolean valid(Map<Character, Integer> s, Map<Character, Integer> m) {
        for (Map.Entry<Character, Integer> e : s.entrySet()) {
            if (!m.containsKey(e.getKey()) || m.get(e.getKey()) < e.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>(); // To keep track of frequency of every character in s
        Map<Character, Integer> counts = new HashMap<>(); // To keep track of frequency of every character in t

        for (char c : t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // As long as the current string is a valid answer, keep removing elements from the left
            while (valid(counts, map)) {
                if (answer.equals("")) {
                    answer = s.substring(start, i + 1);
                } else {
                    answer = answer.length() > i - start + 1 ? s.substring(start, i + 1) : answer;
                }

                char x = s.charAt(start++);
                map.put(x, map.get(x) - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        minWindow(s, t);
    }
}
