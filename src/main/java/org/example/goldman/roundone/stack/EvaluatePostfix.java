package org.example.goldman.roundone.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluatePostfix {
    static Map<Character, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();

    static{
        map.put('+', (a , b) -> a + b);
        map.put('*', (a , b) -> a * b);
        map.put('/', (a , b) -> a / b);
        map.put('-', (a , b) -> a - b);
    }


    public static int evaluatePostfix(String str){
        Stack<Integer> stack=new Stack<>();

        for(int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                stack.push(ch - '0');
            }else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                BiFunction<Integer, Integer, Integer> biFunc = map.get(ch);
                int result = biFunc.apply(val2, val1);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp="100200 + 2 / 5 * 7 +";
        System.out.println("postfix evaluation: "+evaluatePostfix(exp));
    }
}

