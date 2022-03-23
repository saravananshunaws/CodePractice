package org.example.certify;

import java.util.Scanner;

public class WhizExcep1 {
    public static void main(String[] args) {
        scanMe();
    }

    public static void scanMe() {
        try (Scanner scanner1 = new Scanner(System.in); Scanner scanner2 = new Scanner(System.in))  // Line 1
        {
            System.out.println(scanner1.nextLine()); //Line 2
            System.out.println(scanner2.nextLine()); //Line 2
            scanner1.close();
            scanner2.close();

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

}