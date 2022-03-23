package org.example.ds.array;

import java.util.HashMap;
import java.util.Map;

public class SlidingTechnique {

    public static void minSubArray(int[] nums, int k) {
        int window = 0, maxSum;

        for (int i = 0; i < k; i++) {
            window += nums[i];
        }
        maxSum = window;
        for (int i = k; i < nums.length; i++) {
            window = window + nums[i] - nums[i - k];
            maxSum = Math.max(window, maxSum);
        }
        System.out.println("maxSum:: " + maxSum);
    }

    public static void longestUniqueSubstr(String str) {
        Map<Character, Integer> holder = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;

        String temp = "";
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char ch = charArr[i];
            if (temp.contains(ch + "")) {
                startIndex = Math.max(startIndex, temp.indexOf(ch) + 1);
                temp = temp.substring(temp.indexOf(ch) + 1);
            }
            temp += ch;
            maxLength = Math.max(maxLength, i - startIndex + 1);
        }
        System.out.println("Max Length :: " + maxLength);
    }

    private static int findLengthOfLongestSubstringWithKUniqueCharacters(String s, int k) {
        int n = s.length();

        int maxLen = -1; // Stores the length of the longest substring with k unique characters found so far.
        Map<Character, Integer> windowCharCount = new HashMap<>(); // Stores the character count for each character in the current window
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            // Add the next character to the sliding window
            char c = s.charAt(windowEnd);
            windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);

            // Shrink the sliding window, until we have exactly 'k' distinct characters in the window
            while (windowCharCount.size() > k) {
                char leftChar = s.charAt(windowStart);

                // Discard the character at windowStart since we're gonna move it out of the window now.
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (windowCharCount.get(leftChar) == 0) {
                    windowCharCount.remove(leftChar);
                }
                windowStart++; // Shrink the window
            }
            if (windowCharCount.size() == k) {
                // Update maximum length found so far
                maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        // minSubArray(nums, 3);
        //longestUniqueSubstr("geeksforgeeks");
        findLengthOfLongestSubstringWithKUniqueCharacters("aabacbebebe", 3);
    }
}
