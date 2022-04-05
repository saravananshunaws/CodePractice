package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class BuySellMain {

    public static String solution(String transactions) {

        Queue<Character> ll = new LinkedList<>();
        int buyCount = 0, sellCount = 0;
        for(char ch : transactions.toCharArray()){
            ll.add(ch);
            if(ch == 'B'){
                buyCount++;
            } else if(ch == 'S'){
                sellCount++;
            }
        }

        if(buyCount == sellCount){
            return transactions;
        }
        buyCount = Math.min(buyCount, sellCount);

        StringBuffer result = new StringBuffer();

        sellCount = buyCount;
        for(int i=0; i < transactions.length(); i++){
            char ch = transactions.charAt(i);

            if(ch != 'B' && ch != 'S'){
                result.append(ch);
                continue;
            } else if(ch == 'B' && buyCount > 0 ){
                result.append(ch);
                buyCount--;
            } else if(ch == 'S' && sellCount > 0 ){
                result.append(ch);
                sellCount--;
            }

            System.out.println("buyCount " + buyCount + " sellCount " + sellCount + "-" + result);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        solution("BSBBS");
    }
}
