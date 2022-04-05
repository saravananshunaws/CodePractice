package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class SubsetsString {
    public static void main(String[] args) {
        String s = "gfg";
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < s.length(); i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<String> list = new ArrayList<>(result.get(j));
                list.add(s.charAt(i)+"");
                result.add(list);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }


    }
}
