package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class LongestPalindromeSubStr {

    public static String expand(String str, char []array, int i , int j){
        while(i >= 0 && j < array.length && array[i] == array[j]){
            i--;
            j++;
        }
        return str.substring(i + 1, j);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        char[]array = s.toCharArray();
        int maxLength = 0;
        for(int i=0; i < array.length; i++){
            String str  = expand(s, array, i, i);
            if(str.length() > maxLength){
                maxLength = str.length();
            }

            str  = expand(s, array, i, i + 1);
            if(str.length() > maxLength){
                maxLength = str.length();
            }
        }
        System.out.println("Max length :: " + maxLength);
    }
}
