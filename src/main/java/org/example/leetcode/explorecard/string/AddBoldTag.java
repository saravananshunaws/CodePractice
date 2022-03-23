package org.example.leetcode.explorecard.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddBoldTag {

    public static void main(String[] args) {
        String s = "abcxyz123";
        String []words = {"abc","123"};

    }

    public static String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        List<List<int[]>> index = new ArrayList<>();
        for (String w : words) {
            index.add(kmp(s, w));
        }
        for (var i : index) {
            for (var interval : i) {
                Arrays.fill(bold, interval[0], interval[1] + 1, true);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = 0; i < s.length(); i++) {
            if (bold[i] && !start) {
                sb.append("<b>");
                sb.append(s.charAt(i));
                start = true;
            } else if (!bold[i] && start) {
                sb.append("</b>");
                sb.append(s.charAt(i));
                start = false;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (start) {
            sb.append("</b>");
        }
        return sb.toString();
    }

    private static List<int[]> kmp(String s, String w) {
        int[] wKmp = buildKMPArr(w);
        List<int[]> startMatchIndex = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = 0;
            while (i < s.length() && j < w.length()) {
                if (s.charAt(i) == w.charAt(j)) {
                    i++;
                    j++;
                    continue;
                }
                if (j == 0) {
                    i++;
                    continue;
                }
                j = wKmp[j - 1];
            }

            // found
            if (j == w.length()) {
                startMatchIndex.add(new int[]{i - w.length(), i - 1});
                i = i - w.length() + 1;
            }
        }
        return startMatchIndex;
    }

    private static int[] buildKMPArr(String w) {
        int[] kmp = new int[w.length()];
        int i = 0, j = 1;
        kmp[0] = 0;
        while (j < w.length()) {
            if (w.charAt(i) == w.charAt(j)) {
                kmp[j] = i + 1;
                i++;
                j++;
                continue;
            }
            if (i == 0) {
                kmp[j] = 0;
                j++;
                continue;
            }
            i = kmp[i - 1];
        }
        return kmp;
    }
}
