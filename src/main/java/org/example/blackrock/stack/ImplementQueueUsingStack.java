package org.example.blackrock.stack;

import java.util.*;
import java.math.*;
import java.io.*;

public class ImplementQueueUsingStack {
    static Stack<Integer> stack = new Stack<>();

    public static void insertAtBottom(int x){
     if(stack.empty())   {
         stack.push(x);
     }else{
        int temp  = stack.pop();
        insertAtBottom(x);
        stack.push(temp);
     }
    }

    public static void push(int x){
        insertAtBottom(x);
    }

    public static int pop(){
        return stack.pop();
    }

    public static void main(String[] args) {
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}

