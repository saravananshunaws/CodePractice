package org.example.streams;

import java.util.*;
import java.math.*;
import java.io.*;
import java.util.stream.Collectors;

public class StreamsMain {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000));
        employeeList.add(new Employee("Ben", 63, 25000));
        employeeList.add(new Employee("Dave", 34, 56000));
        employeeList.add(new Employee("Jodi", 43, 67000));
        employeeList.add(new Employee("Ryan", 53, 54000));

        System.out.println(employeeList.stream().collect(Collectors.averagingInt(e -> e.getSalary())));
    }
}
