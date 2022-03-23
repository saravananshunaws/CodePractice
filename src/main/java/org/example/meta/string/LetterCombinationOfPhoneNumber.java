package org.example.meta.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class LetterCombinationOfPhoneNumber {
    private static List<String> combinations = new ArrayList<>();
    private static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private static String phoneDigits;

    public static void letterCombinationOfPhoneNumber(String num){
        phoneDigits = num;
        System.out.println(letters);
        backTrack(0, new StringBuilder());
        System.out.println(combinations);
    }

    public static void backTrack(int index, StringBuilder path){
        if(path.length() == phoneDigits.length()){
            combinations.add(path.toString());
            return;
        }

        String digits = letters.get(phoneDigits.charAt(index));
        for(int i=0; i < digits.length(); i++){
            path.append(digits.charAt(i) + "");
            backTrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCombinationOfPhoneNumber("23");
    }
}
