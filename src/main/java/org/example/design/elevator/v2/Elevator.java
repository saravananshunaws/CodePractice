package org.example.design.elevator.v2;

import lombok.Data;

import java.util.*;
import java.math.*;
import java.io.*;

@Data
public class Elevator {
    int id;
    int currentFloor = 0;
    List<Integer> serviceFloors = new ArrayList<>();

    public Elevator(int id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
    }

    public void moveUp(int floor){
        this.currentFloor = floor;
        System.out.println("Elevator ID :: "  + id );
        System.out.println("Moving Elevator UP:: " + floor);
    }

    public void moveDown(int floor){
        this.currentFloor = floor;
        System.out.println("Elevator ID :: "  + id );
        System.out.println("Moving Elevator Down:: " + floor);
    }
}
