package org.example.goldman.roundthree.string;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String  s = "3[a]2[bc]";
        int k= 0;
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuffer> stringStack = new Stack<>();
        StringBuffer currentstring = new StringBuffer();
        for(int i = 0; i < s.length(); i++ ){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k * 10  + ch - '0';
            } else if(ch == '['){
                countStack.push(k);
                k = 0;
                stringStack.push(currentstring);
                currentstring = new StringBuffer();
            }else if(ch == ']'){
                StringBuffer decodedString = stringStack.pop();
                for(int count = countStack.pop(); count > 0;count-- ){
                    decodedString.append(currentstring);
                }
                currentstring = decodedString;
            }
            else{
                currentstring.append(ch);
            }
        }
        System.out.println("Decoded String :: " + currentstring);
    }
}
