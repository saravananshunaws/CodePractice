package org.example.mustdocoding.string;

import java.util.Arrays;

public class FindAllAnagrams {

    static int countManipulations(String s1, String s2) {
        int count = 0;
        int char_count[] = new int[26];
        for (int i = 0; i < s1.length(); i++)
            char_count[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++) {
            char_count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; ++i) {
            if (char_count[i] != 0) {
                count += Math.abs(char_count[i]);
            }
        }
        return count / 2;
    }

    public static void FindAllAnagrams(String s, String p) {

        int[] pArr = new int[26];
        int cArr[] = new int[26];

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pArr[ch - 'a']++;
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            char ch = s.charAt(i);
            cArr[ch - 'a']++;
            if (i >= p.length()) {
                //cArr[ch - 'a']--;
                cArr[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(pArr, cArr)) {
                System.out.println("Index Matching :: " + (i - p.length() + 1));
            }
        }
    }

    public static void main(String[] args) {
        FindAllAnagrams("cbaebabacd", "abc");
    }
}
