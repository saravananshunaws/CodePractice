package org.example.ds.tree.thurs28;

public class LongestPalindrome {

    public static String expand(String str, int low, int high){
        while(low >=0 && high < str.length() && (str.charAt(low) == str.charAt(high))){
            low--;
            high++;
        }
        return str.substring(low+1, high);
    }

    public static void longestPalindrome(String str){
        int maxLength = 0;
        String maxString = "";

        for(int i =0; i <str.length(); i++){
            String currMaxString = expand(str, i, i);
            if(currMaxString.length() > maxLength){
                maxString = currMaxString;
                maxLength = currMaxString.length();
            }

            currMaxString = expand(str, i, i + 1);
            if(currMaxString.length() > maxLength){
                maxString = currMaxString;
                maxLength = currMaxString.length();
            }

        }
        System.out.println("Max String:: " + maxString);
    }

    public static void main(String[] args) {
        String str = "abcgeeksskeegabc";
        longestPalindrome(str);
    }
}
