package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        int i = 0, window = 0;
        int groupCount = 0;
        while(i < s.length()){
            groupCount = 1;
            while(i < s.length() - 1 && s.charAt(i) == s.charAt( i + 1)){
                groupCount++;
                i++;
            }

            if(groupCount != k){
                i++;
                window++;
                continue;
            }

            StringBuffer buffer = new StringBuffer(s);
            buffer.delete(window, groupCount + 1);
            i  = groupCount + 1;
            s = buffer.toString();
        }
        System.out.println("Result:: " + s);
    }
}
