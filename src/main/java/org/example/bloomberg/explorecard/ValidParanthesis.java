package org.example.bloomberg.explorecard;

import java.util.HashMap;
import java.util.Map;

public class ValidParanthesis {

    static Map<Character, Character> charMap = new HashMap<>();

    static {
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Character> entry : charMap.entrySet()) {
            if (map.get(entry.getKey()) == map.get(entry.getValue())) {
                continue;
            }
            System.out.println("Not Valid::");
            break;
        }

        System.out.println("Valid::");
    }
}
