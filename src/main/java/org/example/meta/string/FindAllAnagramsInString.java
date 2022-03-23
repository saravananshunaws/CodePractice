package org.example.meta.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        int [] pCount = new int[26];
        int [] sCount = new int[26];
        for (char ch : p.toCharArray()) {
            pCount[(int)(ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        for (int i = 0; i < ns; ++i) {
            sCount[(int)(s.charAt(i) - 'a')]++;
            if (i >= np) {
                sCount[(int)(s.charAt(i - np) - 'a')]--;
            }
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
