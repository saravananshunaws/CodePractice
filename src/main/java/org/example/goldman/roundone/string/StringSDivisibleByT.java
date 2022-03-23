package org.example.goldman.roundone.string;

public class StringSDivisibleByT {
    public static void main(String[] args) {
        String s1 = "bcdbcdbcdbcd", t1 = "bcdbcd";
        String s2 = "bcdbcdbcd", t2 = "bcdbcd";
        String s3 = "lrbb", t3 = "lrbb";
        System.out.println(getLength(s1, t1));
        //System.out.println(getLength(s2, t2));
        //System.out.println(getLength(s3, t3));
    }

    private static int getLength(String s, String t) {
        if (s.length() % t.length() > 0)
            return -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i * t.length() < s.length(); i++) {
            sb.append(t);
        }
        if (!sb.toString().equals(s))
            return -1;

        for (int i = 1; i <= t.length(); i++) {
            sb = new StringBuilder();
            String subStr = t.substring(0, i);
            while (sb.length() < t.length()) {
                sb.append(subStr);
            }
            if (sb.toString().equals(t))
                return i;
        }
        return -1;
    }
}
