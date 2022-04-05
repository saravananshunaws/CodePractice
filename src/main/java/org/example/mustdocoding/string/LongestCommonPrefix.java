package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        int N = 4;
        String arr[] = {"geeksforgeeks", "geeks", "geek",
                "geezer"};
        Arrays.sort(arr);

        int start = 0, end = 1;
        boolean prefixFound = false;
        for (int i = 0; i < N; i++) {
            prefixFound = false;
           String s = arr[i];
           String prefix = s.substring(start, end);
            for (int j = i + 1; j < N; j++) {
                String s1 = arr[j];
                if(s1.indexOf(prefix) != -1){
                    prefixFound = true;
                    continue;
                }else{
                    prefixFound = false;
                    break;
                }

            }
            if(prefixFound)
                    end++;
        }
        System.out.println("LPS ::" + arr[0].substring(start, end -1));

    }
}
