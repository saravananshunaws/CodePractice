package org.example.meta.stackqueue;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void EvaluateReversePolishNotation(String[] tokens, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if(!"+-/*".contains(token)){
                stack.push(Integer.parseInt(token));
                continue;
            } else{
                int value = 0;
                switch (token){
                    case "+":
                        value = stack.pop() + stack.pop();
                        break;
                    case "*":
                        value = stack.pop() * stack.pop();
                        break;
                }
                stack.push(value);
            }
        }

        System.out.println("Result:: " + stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int n = tokens.length;

        EvaluateReversePolishNotation(tokens, n);
    }
}
