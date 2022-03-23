package org.example.blackrock.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class DecodeString {
    public static void main(String[] args) {
        String s = "2[a]2[bc]";
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuffer> stringStack = new Stack<>();
        StringBuffer currentString = new StringBuffer();
        char []array = s.toCharArray();
        int k = 0;
        stringStack.push(currentString);
        for(int i=0; i < array.length; i++){
            char ch = array[i];
            if(Character.isDigit(ch)){
                k = k * 10  + ch - '0';
            } else if(ch == '['){
                countStack.push(k);
                k = 0;
                stringStack.push(currentString);
                currentString = new StringBuffer();
            }else if(ch == ']'){
                StringBuffer decode = stringStack.pop();
                for(int count = countStack.pop(); count >0 ; count--){
                    decode.append(currentString);
                }
                currentString = decode;
            }else{
                currentString.append(ch);
            }
        }
        System.out.println("Result:: " + currentString);
    }
}
