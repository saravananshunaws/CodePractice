package org.example.blackrock.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class AnagramsFun {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc","bca", "test", "tset");
        Set<String> set = new HashSet<>();

        for(int i=0; i < list.size() -1; i++){
            String s = list.get(i);
            String p = list.get(i + 1);

            char []sArr = s.toCharArray();
            char []pArr = p.toCharArray();

            Arrays.sort(sArr);
            Arrays.sort(pArr);

            if(Arrays.equals(sArr, pArr)){
                set.add(s);
                if(set.contains(p)){
                   // set.remove(p);
                }
            }
        }

        System.out.println("Result:: " + set);
    }
}
