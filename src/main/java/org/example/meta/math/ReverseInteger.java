package org.example.meta.math;

import java.util.*;
import java.math.*;
import java.io.*;

public class ReverseInteger {
    public static void main(String[] args) {
        int  n = 123;
        int carry = 0;
        int rev = 0;
        while(n > 0){
            int mod = n % 10;
            n = n /10;
            rev = rev * 10 + mod;
        }

        System.out.println("Reversed :: " + rev);
    }
}
