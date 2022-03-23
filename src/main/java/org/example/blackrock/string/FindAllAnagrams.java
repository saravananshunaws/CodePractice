package org.example.blackrock.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        int []pArr = new int [26];
        int cArr[] = new int[26];

        for(int i=0; i < p.length(); i++){
            char ch = p.charAt(i);
            pArr[ch - 'a']++;
        }

        for(int i=0; i < s.length() - p.length(); i++){
            char ch = s.charAt(i);
            cArr[ch - 'a']++;
            if(i >= p.length()){
                //cArr[ch - 'a']--;
                cArr[s.charAt(i- p.length()) - 'a']--;
            }

            if(Arrays.equals(pArr, cArr)){
                System.out.println("Index Matching :: " + (i - p.length() + 1));
            }
        }

    }
}
