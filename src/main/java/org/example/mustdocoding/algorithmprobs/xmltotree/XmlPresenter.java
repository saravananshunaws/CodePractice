package org.example.mustdocoding.algorithmprobs.xmltotree;

import java.util.*;
import java.math.*;
import java.io.*;

public class XmlPresenter {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        Node root = parse(tokenizer);
        System.out.println(root);
    }

    static Node parse(Tokenizer tokenizer) {
        Node node = null;
        Stack<Node> tokenStack = new Stack<>();
        Token token = tokenizer.nextToken();
        while (token != null) {
            switch (token.getType()) {
                case BEGIN:
                    tokenStack.push(new Node(token.getValue()));
                    break;
                case TEXT:
                    node = tokenStack.pop();
                    node.setValue(token.getValue());
                    tokenStack.push(node);
                    break;
                case END:
                    node = tokenStack.pop();
                    if (!tokenStack.empty()) {
                        Node parent = tokenStack.pop();
                        parent.addChild(node);
                        tokenStack.push(parent);
                    }
                    break;
            }
            token = tokenizer.nextToken();
        }
        return node;
    }
}