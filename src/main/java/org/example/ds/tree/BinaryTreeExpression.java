package org.example.ds.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class BinaryTreeExpression {
    static Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();

    static{
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> a / b);
    }

    static class Node
    {
        String val;
        Node left, right;

        Node(String val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static int evaluate(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return Integer.parseInt(root.val);
        }

        int x = evaluate(root.left);
        int y = evaluate(root.right);

        int result = 0;
        if(map.containsKey(root.val)){
            BiFunction<Integer, Integer, Integer> func = map.get(root.val);
            result = func.apply(x, y);
        }
        return result;
    }

    public static void main(String[] args)
    {
        Node root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("/");
        root.left.left = new Node("-");
        root.left.right = new Node("5");
        root.right.left = new Node("21");
        root.right.right = new Node("7");
        root.left.left.left = new Node("10");
        root.left.left.right = new Node("5");

        System.out.println("The value of the expression tree is " + evaluate(root));
    }
}
