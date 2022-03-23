package org.example.ds;

import java.util.Arrays;

public class StringMain {
    public static void main(String[] args) {
        String str = "babad";
        //lengthOfLongestSubstring(str);
        patternMatching();
    }

    public static void patternMatching(){
        String input = "AABA";
        String pattern = "AB";
        int len = input.length();
        int i =0, j= 0;
       while (i < len){
            if(j < pattern.length() && input.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                System.out.println("Index Matched At "+ (i - pattern.length()));
                 j = 0;
            }
       }
    }

    public static boolean reverseEquals(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (ch[i] == ch[j]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void lengthOfLongestSubstring(String str) {
        if(str.length() == 1){
            System.out.println(str);
        }
        String currMax = "";
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            temp = "";
            for (int j = i; j < str.length(); j++) {
                temp += str.charAt(j);
                if (reverseEquals(temp)) {
                    if(currMax.length() < temp.length())
                        currMax = temp;
                }
            }
        }
        System.out.println(currMax);
    }
}
