package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class StringRotateByKPlaces {
    public static void main(String[] args) {
        String a = "amazon";
        String b = "zonama";
        int  k = 3;
        char []array = a.toCharArray();
        for (int i = 0; i < k ; i++) {
            char ch = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = ch;
        }
        String result = Arrays.toString(array);
        if(result.equals(b)){
            System.out.println("K Rotated");
        }else{
            System.out.println("Not K Rotated");
        }
    }
}
