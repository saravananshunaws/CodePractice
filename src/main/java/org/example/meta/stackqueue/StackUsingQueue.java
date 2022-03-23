package org.example.meta.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q;

    public StackUsingQueue() {
        q = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);

        int n = q.size();
        while (n > 1) {
            q.add(q.remove());
            n--;
        }
    }

    // Removes the element on top of the stack.
    public int pop() {
        return q.remove();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
