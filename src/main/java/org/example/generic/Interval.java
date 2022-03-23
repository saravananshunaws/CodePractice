package org.example.generic;

import java.util.*;
import java.math.*;
import java.io.*;

public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + "," + end;
    }
}