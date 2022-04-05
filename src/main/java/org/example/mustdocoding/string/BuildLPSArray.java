package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class BuildLPSArray {
    public static void main(String[] args) {
        String str = "abacabad";
        int []lps = new int[str.length()];
        int n = str.length();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(0, i + 1);
            int n1 = s.length();
            for (int j = 1; j < s.length(); j++) {
                String s1 = s.substring(0, j + 1);
                String s2 = s.substring(n1 - j - 1, n1);

                if (s1.equals(s2)) {
                    lps[i] = s1.length();
                }
            }
        }

        System.out.println(Arrays.toString(lps));
    }
}
