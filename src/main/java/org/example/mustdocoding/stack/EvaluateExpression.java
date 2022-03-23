package org.example.mustdocoding.stack;

import java.util.Stack;

public class EvaluateExpression {

    public static int calculate2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // recursive Time and Space O(N)
    static int i = 0;
    public static int calculate3(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0, tmp = 0, num = 0;
        char op = '+';

        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
            } else if (c == '(') {
                tmp = calculate3(s);     // string parse index is tracked by i
            } else if (c == ')') {
                break;
            } else if (c != ' ') {
                //process the numerical value of string so far; based on what 'op' we have before it
                num = cal(num, tmp, op);
                if (c == '+' || c == '-') {
                    result += num;
                    num = 0;
                }
                //reset 'tmp' and op for next character  processing
                tmp = 0;
                op = c;
            }
        }
        return result + cal(num, tmp, op);
    }
    private static int cal(int num, int tmp, char op) {
        if (op == '+') return num + tmp;
        else if (op == '-') return num - tmp;
        else if (op == '*') return num * tmp;
        else return num / tmp;
    }

    public static void main(String[] args) {
        System.out.println(calculate2("3*5+10"));
    }

}
