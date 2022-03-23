package org.example.goldman.roundthree.string;

import java.util.Arrays;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        int[] pArr = new int[26];
        int[] sArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                sArr[s.charAt(i-p.length()) - 'a']--;
            }

            if(Arrays.equals(sArr, pArr)){
                System.out.println(i- p.length() + 1);
            }
        }
    }
}
