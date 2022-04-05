package org.example.mustdocoding.tree;

import java.util.*;
import java.math.*;
import java.io.*;
import java.util.function.BiFunction;

public class ExpressionTree {
    static abstract class Node {
        public abstract int evaluate();
        public Node left;
        public Node right;
        public String val;

        protected Node(String val) {
            this.val = val;
        }
    };

    static class ExpressionNode extends Node {
        @Override
        public int evaluate() {
            Node node = this;
            String curVal = node.val;
            if (Operator.isOperator(curVal)) {
                int left = node.left.evaluate();
                int right = node.right.evaluate();
                return Operator.operate(left, right, curVal);
            }
            return Integer.parseInt(curVal);
        }

        ExpressionNode(String val) {
            super(val);
        }
    }

    static class Operator {
        private final static Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS_MAP = new HashMap<>();
        static {
            // Returns the right operation
            OPERATIONS_MAP.put("+", (a, b) -> a + b);
            OPERATIONS_MAP.put("-", (a, b) -> a - b);
            OPERATIONS_MAP.put("/", (a, b) -> a / b);
            OPERATIONS_MAP.put("*", (a, b) -> a * b);
        }

        public static boolean isOperator(String s) {
            return OPERATIONS_MAP.containsKey(s);
        }

        public static int operate(int val1, int val2, String operator) {
            return OPERATIONS_MAP.get(operator).apply(val1, val2);
        }
    }

    static class TreeBuilder {
        static Node buildTree(String[] postfix) {
            Deque<ExpressionNode> stack = new ArrayDeque<>();
            for (String curValue : postfix) {
                if (Operator.isOperator(curValue)) {
                    ExpressionNode node = new ExpressionNode(curValue);
                    node.right = stack.pop();
                    node.left = stack.pop();
                    stack.push(node);
                } else {
                    stack.push(new ExpressionNode(curValue));
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        String []s = {"3","4","+","2","*","7","/"};
        Node node = TreeBuilder.buildTree(s);
        System.out.println(node);
    }
}
