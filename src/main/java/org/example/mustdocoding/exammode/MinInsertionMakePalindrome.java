package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinInsertionMakePalindrome {
    public static void main(String[] args) {
        String str = "ab";
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            System.out.println(n-i-1);
            if(str.charAt(i) == str.charAt(n-i-1)){
                continue;
            }
            count++;

            if(str.charAt(i) < str.charAt(n-i-1))
                str = str.replace(str.charAt(n-i-1), str.charAt(i));
            else
                str = str.replace( str.charAt(i), str.charAt(n-i-1));

            System.out.println("After Insert " + str);
        }

        System.out.println(count);
    }
}
