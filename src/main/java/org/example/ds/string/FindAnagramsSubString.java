package org.example.ds.string;

import java.util.*;

public class FindAnagramsSubString {

    public static List<Integer> findAnagrams(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        int [] pCount = new int[26];
        int [] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[(int)(ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // add one more letter
            // on the right side of the window
            sCount[(int)(s.charAt(i) - 'a')]++;
            // remove one letter
            // from the left side of the window
            if (i >= np) {
                sCount[(int)(s.charAt(i - np) - 'a')]--;
            }
            // compare array in the sliding window
            // with the reference array
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";

       // System.out.println(findAnagrams(s, p));

        char []pArr  = new char[26];
        char []sArr = new char[26];

        for(int i=0; i < p.length(); i++){
            pArr[p.charAt(i) - 'a']++;
        }

        int pLength = p.length();
        for(int i=0; i < s.length(); ++i){
             char ch = s.charAt(i);
             sArr[ch - 'a']++;

             if(i >= p.length()){
                 sArr[s.charAt(i - pLength) - 'a']--;
             }

            if(Arrays.equals(pArr, sArr)){
                System.out.println((i - pLength + 1));
            }
        }
    }
}
