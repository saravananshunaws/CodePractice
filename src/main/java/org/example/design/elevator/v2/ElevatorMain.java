package org.example.design.elevator.v2;

import java.util.*;
import java.math.*;
import java.io.*;

public class ElevatorMain {
    public static void main(String[] args) throws InterruptedException {
        List<Elevator> elevatorList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Elevator elevator = new Elevator(i, 0);
            elevatorList.add(elevator);
        }

        ElevatorControlSystem controlSystem = new ElevatorControlSystem(elevatorList);
        controlSystem.setElevatorList(elevatorList);

        for (int i = 0; i < 1; i++) {
            int floor = new Random().nextInt(5);
            if(floor % 2 == 0) {
                controlSystem.requestFloor(Direction.UP, floor);
            }else{
                controlSystem.requestFloor(Direction.DOWN, floor);
            }
        }

        Thread.currentThread().join();
    }
}
