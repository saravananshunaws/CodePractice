package org.example.goldman.roundthree.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String []strArray = {"geeksforgeeks", "geaks", "geek", "geezer"};
        Arrays.sort(strArray);
        int size = strArray.length;
        int min = Math.min(strArray[0].length(), strArray[size - 1].length());
        int i=0;
        while(i < min && strArray[0].charAt(i) == strArray[size - 1].charAt(i)){
            i++;
        }
        System.out.println(strArray[0].substring(0, i));
    }
}
