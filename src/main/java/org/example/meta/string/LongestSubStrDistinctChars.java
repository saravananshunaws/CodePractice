package org.example.meta.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class LongestSubStrDistinctChars {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubStrDistinctChars.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + LongestSubStrDistinctChars.findLength("abccde"));
    }
}
