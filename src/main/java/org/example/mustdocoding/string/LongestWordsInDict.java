package org.example.mustdocoding.string;

import java.util.List;

public class LongestWordsInDict {
    static boolean isSubSequence(String str1,
                                 String str2) {
        int m = str1.length(), n = str2.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (str1.charAt(j) == str2.charAt(i)) {
                j++;
            }
        }
        return (j == m);
    }

    static String findLongestWord(String S, List<String> d) {
        String max_str = "";
        for (String word : d) {
            if (isSubSequence(word, S)) {
                if (word.length() > max_str.length() ||
                        (word.length() == max_str.length() &&
                                word.compareTo(max_str) < 0))
                    max_str = word;
            }
        }

        // Return longest String
        return max_str;
    }

    public static void main(String[] args) {
        String[] d = {"ale", "apple", "monkey", "plea"};
        String S = "abpcplea";

    }
}
