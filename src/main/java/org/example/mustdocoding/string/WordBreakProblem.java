package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class WordBreakProblem {
    public static boolean canSegmentString(String s, Set<String> dictionary) {

        int left = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            for(String word : dictionary ){
                System.out.println("Word SubStr :: " + s.substring(left, i + 1));
                if(s.substring(left, i+ 1).equals(word)){
                    System.out.println("Word matched :: " + word + " left :: " + left + " i :: " + i);
                    left = i + 1;
                    break;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("pear");
        set.add("pier");
        set.add("pie");
        canSegmentString("applepie", set);

    }
}
