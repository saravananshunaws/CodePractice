package org.example.mustdocoding.stack;

import java.util.Stack;

public class QueueUsingStacks {

    public static Stack<Integer> S1 = new Stack<>();
    public static Stack<Integer> S2 = new Stack<>();

    public static void enQueue(int data) {
        S1.push(data);
    }

    public static int deQueue() {
        if (S1.isEmpty() && S2.isEmpty()) {
            return -1;
        }

        if (S2.isEmpty()) {
            while (!S1.isEmpty()) {
                S2.push(S1.pop());
            }
        }
        return S2.pop();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length; i++) {
            enQueue(nums[i]);
        }

        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
    }
}
