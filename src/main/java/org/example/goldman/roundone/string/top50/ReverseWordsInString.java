package org.example.goldman.roundone.string.top50;

public class ReverseWordsInString {

    public static String reverse(String word) {
        int start = 0, end = word.length() -1;
        char[] temp = new char[end + 1];
        while (start <= end) {
            char ch = word.charAt(start);
            temp[start] = word.charAt(end);
            temp[end] = ch;
            start++;
            end--;
        }

        return new String(temp);
    }

    public static void ReverseWordsInString(String s) {
        String reversedStr = reverse(s);
        System.out.println("Reversed Main String :: " + reversedStr);
        String []wordsArray = reversedStr.split("\\s+");
        for(String word: wordsArray){
            System.out.print(reverse(word) + " ");
        }
    }

    public static void main(String[] args) {
        String s = "i love you";
        ReverseWordsInString(s);
    }
}
