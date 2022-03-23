package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        int tArr[]= new int [26];
        int sArr[]= new int [26];

        for (int i = 0; i < t.length(); i++) {
            System.out.print((t.charAt(i) - 'a') + " ");
            tArr[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
           sArr[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sArr, tArr)){
            System.out.println("Valid Anagram");
        }else{
            System.out.println("Not a Valid Anagram");
        }

    }
}
