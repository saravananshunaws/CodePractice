package org.example.goldman.roundone.string;

import java.util.*;

public class DictionaryWord {
    public static void main(String[] args) {
        String[] words = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
        String input = "eot";
        int[] freq = new int[26];
        int maxLength = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch - 'a']++;
        }

        for (String word : words) {
            if (canBeMade(word, freq.clone())) {
                if (word.length() == maxLength) {
                    System.out.println(word);
                } else if (word.length() > maxLength) {
                    System.out.println(word);
                }
            }
        }
    }

    public static boolean canBeMade(String word, int[] freq) {
        for (char ch : word.toCharArray()) {
            if (freq[ch - 'a'] == 0) {
                return false;
            } else {
                freq[ch - 'a']--;
            }
        }
        return true;
    }
}
