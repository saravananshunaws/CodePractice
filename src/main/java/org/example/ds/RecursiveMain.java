package org.example.ds;

public class RecursiveMain {

    public static void main(String[] args) {
        int num = 151;
        System.out.println(15 % 10);
        int sum =0;
        while(num >= 0){
            int rem = num % 10;
            int n = num / 10;
        }
    }

    public static void palindrome(String str, int start, int end){
        if(start >= end){
            return;
        }

        if(str.charAt(start) == str.charAt(end)){
            palindrome(str, ++start, --end);
        }

    }
}
