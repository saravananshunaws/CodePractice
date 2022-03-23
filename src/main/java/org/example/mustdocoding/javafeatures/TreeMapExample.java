package org.example.mustdocoding.javafeatures;

import java.util.*;
import java.math.*;
import java.io.*;

public class TreeMapExample  {

    static class Student {
        int rollno;
        String name, address;

        public Student(int rollno, String name, String address){
            this.rollno = rollno;
            this.name = name;
            this.address = address;
        }

        public String toString() {
            return this.rollno + " " + this.name + " "
                    + this.address;
        }
    }

    public static void main(String[] args) {

        Comparator<Student> rollNoComparator  = Comparator.comparingInt(s -> s.rollno);

        TreeMap<Student, Integer> tree_map = new TreeMap<Student, Integer>(rollNoComparator);

        tree_map.put(new Student(111, "bbbb", "london"), 2);
        tree_map.put(new Student(131, "aaaa", "nyc"), 3);
        tree_map.put(new Student(121, "cccc", "jaipur"), 1);

        System.out.println(tree_map);
    }
}
