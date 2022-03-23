package org.example.goldman.roundone.string.top50;

import org.example.threads.InterThreadCommunication;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String ip = "222.111.111.111";

        long count = ip.chars().filter(ch -> ch == '.').count();
        boolean valid = true;
        if (count != 3) {
            valid = false;
        }

        String[] strs = ip.split(".");
        for (String s : strs) {
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) {
                valid = false;
            }
        }
        if (valid) {
            System.out.println("Valid ");
        } else {
            System.out.println("Not Valid ");
        }
    }
}
