package org.example.certify;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileMain {
    public static void main(String[] args)throws Exception {
        Path root = Path.of("root");
        Path b = Path.of("root/a/b");
        Path c = Path.of("root/c");
        Files.createDirectories(b);
        Files.createDirectory(c);
        Files.walk(root).forEach(System.out::println);
    }
}
