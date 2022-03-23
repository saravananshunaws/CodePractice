package org.example.mustdocoding.javafeatures;

import java.util.*;
import java.math.*;
import java.io.*;
import java.util.stream.Collectors;

public class JavaStreams {

    static class Employee{
        public int empId;
        public long salary;
        public String department;
        public String country;

        public Employee(int empId, long salary, String department, String country) {
            this.empId = empId;
            this.salary = salary;
            this.department = department;
            this.country = country;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    public static void groupingByExample(List<Employee> list){
        Map<String, List<Employee>> map = list.stream().filter(e -> e.country.equals("USA"))
                .collect(Collectors.groupingBy(emp -> emp.department));
        System.out.println(map);
    }

    public static void treeMapByExample(List<Employee> list){
        Comparator<Integer> comparator = Integer::compare;
        TreeMap<Integer, Employee> treeMap = new TreeMap(comparator);
        for(Employee e : list){
            treeMap.put(e.empId, e);
        }

        System.out.println(treeMap);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(100, 1000, "DEV", "USA");
        Employee e2 = new Employee(101, 1000, "HR", "USA");
        Employee e3 = new Employee(102, 1000, "HR", "IND");
        Employee e4 = new Employee(103, 1000, "MANAGER", "USA");
        Employee e5 = new Employee(104, 1000, "MANAGER", "IND");

        List<Employee> list  = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
        groupingByExample(list);
        treeMapByExample(list);
    }
}
