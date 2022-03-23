package org.example.blackrock.stack;

import java.util.Stack;

public class MinParanthesisToAdd {
    public static void main(String[] args) {
        String s = "((";
        Stack<Character> openstack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openstack.push(ch);
            } else {
                if (openstack.empty()) count++;
                else
                    openstack.pop();
            }
        }

        System.out.println("Stack Size :: " + (openstack.size() + count));
    }
}
