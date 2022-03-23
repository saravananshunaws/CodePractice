package org.example.meta.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class ValidPalindromDeletedOneChar {
    public static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static  boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                //skip left OR skip right -> delete atmost one character
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
}
