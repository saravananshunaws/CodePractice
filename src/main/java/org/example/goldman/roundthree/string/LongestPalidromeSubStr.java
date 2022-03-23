package org.example.goldman.roundthree.string;

public class LongestPalidromeSubStr {

    public static String isPalindrome(String str, int start, int end){
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        return str.substring(start + 1, end);
    }

    public static int findLongestPalindromicSubstring(String  str){
        int max_length = 0;
        String palindrome = "";
        for(int i=0; i < str.length(); i++){
            String s1 = isPalindrome(str, i, i);

            if(s1.length() > max_length){
                max_length = s1.length();
                palindrome = s1;
            }

            String s2 = isPalindrome(str, i, i + 1);
            if(s2.length() > max_length){
                max_length = s2.length();
                palindrome = s2;
            }
        }
        System.out.println("Max Length :: " + max_length);
        System.out.println("palindrome :: " + palindrome);
        return max_length;
    }

    public static void main(String[] args) {
        String str = "abccbaxyz";
        System.out.println("The longest palindromic substring of " + str + " is "
                + findLongestPalindromicSubstring(str));
    }
}
