package org.example.mustdocoding.stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> s;       // main stack to store elements
    private Stack<Integer> aux;     // auxiliary stack to store minimum elements

    // Constructor
    public MinStack() {
        s = new Stack<>();
        aux = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        if (aux.isEmpty()) {
            aux.push(val);
        } else {
            if (aux.peek() >= val) {
                aux.push(val);
            }
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }
        int top = s.pop();
        if (top == aux.peek()) {
            aux.pop();
        }
        return top;
    }

    public int getMin() {
        if (aux.isEmpty()) {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }

        return aux.peek();
    }

    public int top() {
        return s.peek();
    }

    public int size() {
        return s.size();
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        s.push(6);
        System.out.println(s.getMin());    // prints 6

        s.push(7);
        System.out.println(s.getMin());    // prints 6

        s.push(8);
        System.out.println(s.getMin());    // prints 6

        s.push(5);
        System.out.println(s.getMin());    // prints 5

        s.push(3);
        System.out.println(s.getMin());    // prints 3

        System.out.println(s.pop());    // prints 3
        System.out.println(s.getMin());    // prints 5

        s.push(10);
        System.out.println(s.getMin());    // prints 5

        System.out.println(s.pop());    // prints 10
        System.out.println(s.getMin());    // prints 5

        System.out.println(s.pop());    // prints 5
        System.out.println(s.getMin());    // prints 6
    }

}
