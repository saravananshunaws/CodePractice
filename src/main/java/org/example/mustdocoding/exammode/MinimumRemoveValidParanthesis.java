package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinimumRemoveValidParanthesis {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        int openSeen = 0, balance = 0;
        int openToKeep = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                openSeen++;
                balance++;
            } else if(ch == ')'){
                if(balance == 0) continue;
                balance--;
            }
            sb.append(ch);
        }

        StringBuilder result = new StringBuilder();
        openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '('){
                openToKeep--;
                if(openToKeep < 0 ) continue;
            }
            result.append(ch);
        }
        System.out.println(result);
    }
}
