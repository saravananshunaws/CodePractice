package org.example.meta.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveValidParanthesis {
    public static void main(String[] args) {
        String s = "le)e(t(c)o)de)";
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexToBeRemoved = new HashSet<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if(stack.empty()){
                    indexToBeRemoved.add(i);
                }else{
                    stack.pop();
                }
            }
        }

        while (!stack.empty()){
            indexToBeRemoved.add(stack.pop());
        }

        String result = "";
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if(!indexToBeRemoved.contains(i)){
                result += ch;
            }
        }
        System.out.println("Result :: " + result);

    }
}
