package org.example.mustdocoding.string;

import java.text.DecimalFormat;
import java.util.*;
import java.math.*;
import java.io.*;

public class SumOfTwoLargeNumbers {
    public static void sum(){
        String str1 = "9999999";
        String str2 = "9999999";

        if (str1.length() > str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        String str = "";
        int n1 = str1.length(), n2 = str2.length();
        str1=new StringBuilder(str1).reverse().toString();
        str2=new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++)
        {
            int sum = (str1.charAt(i) - '0') +
                    (str2.charAt(i) - '0') + carry;
            str += sum % 10 ;
            carry = sum / 10;
        }
        for (int i = n1; i < n2; i++)
        {
            int sum =(str2.charAt(i) - '0') + carry;
            str += sum % 10 ;
            carry = sum / 10;
        }
        if (carry > 0)
            str += carry;

        str = new StringBuilder(str).reverse().toString();
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        System.out.println(decimalFormat.format(Long.valueOf(str)));
    }

    public static void main(String[] args) {
        sum();
    }
}
