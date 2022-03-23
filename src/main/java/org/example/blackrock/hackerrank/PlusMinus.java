package org.example.blackrock.hackerrank;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        float pos = 0, neg = 0, zero = 0;
        for(int elem : arr){
            if(elem < 0){
                neg++;
            } else if(elem > 0){
                pos++;
            }else{
                zero++;
            }
        }
        NumberFormat format = new DecimalFormat("#0.000000");
        System.out.println(format.format(pos / arr.size()));
        System.out.println(format.format(neg / arr.size()));
        System.out.println(format.format(zero / arr.size()));

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(-4);
        arr.add(3);
        arr.add(-9);
        arr.add(0);
        arr.add(4);
        arr.add(1);
        plusMinus(arr);
    }
}
