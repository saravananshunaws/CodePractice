package org.example.design.elevator.v2;

import lombok.Data;

import java.util.*;
import java.math.*;
import java.io.*;

@Data
public class ElevatorRequest {
    Direction direction;
    int floor;

    public ElevatorRequest(Direction direction, int floor) {
        this.direction = direction;
        this.floor = floor;
    }
}
