package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        int m = text1.length();
        int n = text2.length();
        int [][]dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i ==0 || j ==0){
                    dp[i][j] = 0;
                }
                else if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println("LCS :: " + dp[m][n]);
    }
}
