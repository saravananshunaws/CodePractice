package org.example.meta.others;

import java.util.*;
import java.math.*;
import java.io.*;
import java.util.stream.Collectors;

public class DinosaurProblem {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> ds1 = new BufferedReader(new FileReader("C:\\dev\\study\\java\\CodePractice\\src\\main\\java\\org\\example\\meta\\others\\ds1.csv"))
                .lines()
                .skip(1) //Skips the first n lines, in this case 1
                .collect(Collectors.toList());

        System.out.println(ds1);

        List<String> ds2 = new BufferedReader(new FileReader("C:\\dev\\study\\java\\CodePractice\\src\\main\\java\\org\\example\\meta\\others\\ds2.csv"))
                .lines()
                .skip(1) //Skips the first n lines, in this case 1
                .collect(Collectors.toList());

        System.out.println(ds2);

    }
}
