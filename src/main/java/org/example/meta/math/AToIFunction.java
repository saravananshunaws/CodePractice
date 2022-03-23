package org.example.meta.math;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.math.*;
import java.io.*;

public class AToIFunction {
    public static void main(String[] args) {
        String str = "    -42";
        int sign = 0, n = str.length();
        int i = 0, index = 0;
        while(i < n && str.charAt(i) == ' '){
            index++;
            i++;
        }

        if(str.charAt(index) == '+'){
            sign = 1;
            index++;
        } else if(str.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        int current = 0;
        while(index < n && Character.isDigit(str.charAt(index))){
           int digit = str.charAt(index) - '0';
            if(digit > Integer.MAX_VALUE / 10 || (digit >= Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){

            }

            current = current * 10 + (digit % 10);
            index++;
        }
        System.out.println(sign * current);
    }
}
