package org.example.ds;

public class Fibonacci {

    public static int fib(int num, String name){
        if (num <= 1)
            return num;
        System.out.println("Name " + name +" , Num " + num);
        return fib(num - 1 , "first") + fib(num - 2, "second");
    }

    public static void main(String[] args) {
        System.out.println(fib(5, "Main"));
    }
}
