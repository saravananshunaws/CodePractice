package org.example.mustdocoding.math;

import java.util.*;
import java.math.*;
import java.io.*;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        int val = 0;

        while(x > 0 ){
            int rem = x % 10;
            val = val * 10 + rem;
            x = x / 10;
        }

        System.out.println("Value :: " + val);
    }
}
