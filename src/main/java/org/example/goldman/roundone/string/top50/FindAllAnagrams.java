package org.example.goldman.roundone.string.top50;

import java.util.Arrays;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        int start =0;
        int freq[] = new int[26];
        int temp[] = new int[26];
        for(int i=0; i < p.length(); i++){
            freq[p.charAt(i) - 'a']++;
        }

        for(int i=0; i < s.length() - p.length(); i++){
            temp[s.charAt(i) -'a']++;
            if(i >= p.length()){
                temp[s.charAt(i - p.length()) -'a']--;
            }

            if(Arrays.equals(freq, temp)){
                System.out.println("Matching Index:: " + (i - p.length() + 1) );
            }
        }
    }
}
