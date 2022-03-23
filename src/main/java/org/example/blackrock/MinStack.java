package org.example.blackrock;

import java.util.*;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();

    public MinStack() { }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[]{x, 1});
        }
        else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
