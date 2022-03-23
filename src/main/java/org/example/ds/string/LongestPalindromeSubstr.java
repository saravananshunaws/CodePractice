package org.example.ds.string;

public class LongestPalindromeSubstr {

    public static String palindromeString(String str, int low, int high) {
        while (low >= 0 && high < str.length() && (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
        }
        return str.substring(low + 1, high);
    }


    public static void findLongestPalindromeSubstr(String str) {
        int max_length = 0;
        String palindrome = "";
        for (int i = 0; i < str.length(); i++) {
            String result = palindromeString(str, i, i);
            if (result.length() > max_length) {
                max_length = result.length();
                palindrome = result;
            }

            result = palindromeString(str, i, i + 1);
            if (result.length() > max_length) {
                max_length = result.length();
                palindrome = result;
            }
        }
        System.out.println("Palindrome:: " + palindrome);
    }

    // Expand in both directions of `low` and `high` to find maximum length palindrome
    public static String expand(String str, int low, int high) {
        // expand in both directions
        while (low >= 0 && high < str.length() &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
        }

        // return palindromic substring
        return str.substring(low + 1, high);
    }

    // Function to find the longest palindromic substring in `O(n²)` time
    // and `O(1)` space
    public static String findLongestPalindromicSubstring(String str) {
        // base case
        if (str == null || str.length() == 0) {
            return str;
        }

        // `max_str` stores the maximum length palindromic substring
        // found so far

        String max_str = "", curr_str;

        // `max_length` stores the maximum length of palindromic
        // substring found so far

        int max_length = 0, curr_length;

        // consider every character of the given string as a midpoint and expand
        // in both directions to find maximum length palindrome

        for (int i = 0; i < str.length(); i++) {
            // find the longest odd length palindrome with `str[i]` as a midpoint

            curr_str = expand(str, i, i);
            curr_length = curr_str.length();


            // update maximum length palindromic substring if odd length
            // palindrome has a greater length

            if (curr_length > max_length) {
                max_length = curr_length;
                max_str = curr_str;
            }

            // Find the longest even length palindrome with str[i] and
            // str[i+1] as midpoints. Note that an even length palindrome
            // has two midpoints.

            curr_str = expand(str, i, i + 1);
            curr_length = curr_str.length();

            // update maximum length palindromic substring if even length
            // palindrome has a greater length

            if (curr_length > max_length) {
                max_length = curr_length;
                max_str = curr_str;
            }
        }

        return max_str;
    }

    public static void main(String[] args) {
        String str = "abccbaxyz";
        findLongestPalindromeSubstr(str);
        System.out.println("The longest palindromic substring of " + str + " is "
                + findLongestPalindromicSubstring(str));
    }
}
