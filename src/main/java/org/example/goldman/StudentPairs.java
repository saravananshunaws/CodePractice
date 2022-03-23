package org.example.goldman;

import java.util.ArrayList;
import java.util.List;

public class StudentPairs {
    static class Student {
        public String name;
        public int mark;

        public Student(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }

        @Override
        public String toString() {
            return name + "-" + mark ;
        }
    }

    public static void pair(List<Student> list) {
        List<List<Student>> pair = new ArrayList<>();
        int d = 150;
        for (int i = 0, j = 1; i < list.size() && j < list.size(); i++, j++) {
            Student s1 = list.get(i);
                Student s2 = list.get(j);
                if (Math.abs(s1.mark + s2.mark) == d) {
                    pair.add(new ArrayList<>(List.of(new Student[]{s1, s2})));
                }
        }
        System.out.println(pair);
    }

    public static void main(String[] args) {
        Student s1 = new Student("ron", 50);
        Student s2 = new Student("harry", 100);
        Student s3 = new Student("naruto", 150);
        Student s4 = new Student("diego", 0);
        Student s5 = new Student("tom", 50);
        Student s6 = new Student("jerry", 100);
        Student s7 = new Student("shika", 90);
        Student s8 = new Student("tenten", 60);
        Student s9 = new Student("sasuke", 100);
        Student s10 = new Student("gara", 114);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        list.add(s9);
        list.add(s10);
        pair(list);
    }

}
