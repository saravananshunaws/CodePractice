package org.example.meta;

import java.util.*;
import java.math.*;
import java.io.*;

public class JavaMain {
    public static void main(String[] args) {
        TreeSet <Integer>obj = new TreeSet<Integer>();
        obj.add(2);
        obj.add(8);
        obj.add(5);
        obj.add(1);
        obj.add(10);
        System.out.println("TreeSet: " +obj);
        System.out.println("Ceiling value of 3 in set: " +obj.ceiling(2));
    }
}
