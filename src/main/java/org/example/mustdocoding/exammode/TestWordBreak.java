package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class TestWordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        String []wordDict = {"leet","code"};
        boolean[] dp = new boolean[s.length()];
        for(int i=0; i < s.length(); i++){
            for(String word : wordDict){
                int wordLength = word.length();
                if(i >= wordLength - 1 && (i == word.length() - 1  || dp[i - word.length()])){
                    int subStr = i - wordLength  + 1;
                    String temp = s.substring(subStr, i + 1);
                    if(temp.equals(word) ){
                        System.out.println("Word matched :: " + s.substring(i -wordLength + 1 , i + 1));
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
    }
}
