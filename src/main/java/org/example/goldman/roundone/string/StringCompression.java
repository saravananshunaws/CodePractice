package org.example.goldman.roundone.string;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aaabbcc".toCharArray()));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int slow = 0, fast = 0, groupLen;
        while (fast < chars.length) {
            groupLen = 1;
            while ((fast < chars.length - 1) && chars[fast] == chars[fast + 1]) {
                groupLen++;
                fast++;
            }
            chars[slow] = chars[fast];
            slow++;
            fast++;
            if (groupLen > 1) {
                // If the groupLen > 9, we would need multiple chars e.g. 12 > '1', '2'.
                for (char c : String.valueOf(groupLen).toCharArray()) {
                    chars[slow] = c;
                    slow++;
                }
            }
        }
        return slow;
    }
}
