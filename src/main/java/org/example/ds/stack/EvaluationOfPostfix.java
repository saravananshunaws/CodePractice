package org.example.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluationOfPostfix {

    static Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();

    static{
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> a / b);
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        String []tokens = {"2","1","+","3","*"};

        for(int i=0; i <tokens.length; i++){
            if(!map.containsKey(tokens[i])){
                stack.push(tokens[i]);
                continue;
            }

            int number1 = Integer.parseInt(stack.pop());
            int number2 = Integer.parseInt(stack.pop());

            BiFunction<Integer, Integer, Integer> func = map.get(tokens[i]);
            result = func.apply(number1, number2);
            stack.push(String.valueOf(result));
        }

        System.out.println("Result:: " + stack.pop());
    }
}
