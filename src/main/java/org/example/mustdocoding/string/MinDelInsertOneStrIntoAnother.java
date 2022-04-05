package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinDelInsertOneStrIntoAnother {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "fbc";

        int diff = LCS.lcs(s1, s2);
        System.out.println("LCS :: " + diff);
        System.out.println("Min Insertions:: " + (s1.length() - diff));
        System.out.println("Min Deletions:: " + (s2.length() - diff));
    }
}
