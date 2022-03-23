package org.example.goldman.roundone.string;

public class LongestPalindrome {

    public static String expand(char []array, String str, int start, int end){
        while(start >= 0 && end < str.length() && (str.charAt(start) == str.charAt(end))){
            start--;
            end++;
        }
        return str.substring(start + 1, end);
    }

    public static void main(String[] args) {
        String str = "abccbaxyz";
        char []array = str.toCharArray();
        for(int i=0; i < str.length(); i++){
            String s1 = expand(array, str, i, i);
            System.out.println("expand:: " + s1);

            String s2 = expand(array, str, i, i+1);
            System.out.println("expand:: " + s2);
        }
    }
}
