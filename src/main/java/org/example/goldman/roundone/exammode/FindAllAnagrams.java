package org.example.goldman.roundone.exammode;

import java.util.Arrays;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String  s = "cbaebabacd", p = "abc";
        int sArr[] = new int[26];
        int pArr[] = new int[26];
        int sLen = s.length(), pLen = p.length();

        for(int i=0; i < pLen; i++){
            pArr[p.charAt(i) - 'a']++;
        }

        for(int i=0; i < sLen; i++){
            int ch = s.charAt(i);
            sArr[ch - 'a'] ++;

            if(i >=pLen){
                    sArr[s.charAt(i - pLen) - 'a']--;
            }

            if(Arrays.equals(sArr, pArr)){
                System.out.println("Index:: "  + (i - pLen + 1  ));
            }
        }
    }
}
