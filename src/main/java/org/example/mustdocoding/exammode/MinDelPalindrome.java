package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinDelPalindrome {
    public static void main(String[] args) {
        String S = "aebcbda";
        String R = new StringBuffer(S).reverse().toString();
        int m = S.length(), n = R.length();
        int dp [][] = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                } else if(S.charAt(i-1) == R.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(m - dp[m][n]);
    }
}
