package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class TestDecodeString {
    public static void main(String[] args) {
        String s = "2[a]2[bc]";
        StringBuffer buffer = new StringBuffer();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuffer> strStack = new Stack<>();
        int count = 0;
        strStack.push(buffer);
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(Character.isDigit(ch)){
                count = count * 10  + ch - '0';
                continue;
            }else if(ch == '['){
                countStack.push(count);
                strStack.push(buffer);
                buffer = new StringBuffer();
                count = 0;
            } else  if(ch == ']'){
                StringBuffer temp = strStack.pop();
                for(int count1 = countStack.pop() -1; count1 >=0 ; count1--){
                    temp.append(buffer);
                }
                buffer = temp;
            }
            else {
                buffer.append(ch);
            }
        }
    }
}
