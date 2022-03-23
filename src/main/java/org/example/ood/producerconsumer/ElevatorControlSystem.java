package org.example.ood.producerconsumer;

import java.util.*;
import java.util.concurrent.SubmissionPublisher;

public class ElevatorControlSystem {
    Queue<Integer> upQueue;
    Queue<Integer> downQueue;

    int numberOfElevators = 5;
    List<Elevator> elevatorList;

    public enum Direction {
        NONE, UP, DOWN
    }

    public enum State {
        MOVING, STOPPED
    }

    public enum Door {
        OPEN, CLOSED
    }

    public ElevatorControlSystem() {
        Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);
        Comparator<Integer> reversed = (a, b) -> Integer.compare(b, a);
        upQueue = new PriorityQueue<>(comparator);
        downQueue = new PriorityQueue<>(reversed);

        elevatorList = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            Elevator elevator = new Elevator();
            elevatorList.add(elevator);
        }

        for (Elevator elevator : elevatorList) {
            //new Thread(elevator).start();
        }

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        Elevator<String> subscriber = new Elevator<>();
        publisher.subscribe(subscriber);
    }

    public void requestFloor(int floor, Direction direction) {
        for (Elevator elevator : elevatorList) {
            if((elevator.getDirection() == Direction.NONE || elevator.getDirection() == Direction.UP)
                                && floor > elevator.getCurrentFloor()){
                elevator.getCurrent().add(floor);
            }

            if((elevator.getDirection() == Direction.DOWN)
                    && floor < elevator.getCurrentFloor()){
                elevator.getCurrent().add(floor);
            }
        }
    }

    public static void main(String[] args) {
        ElevatorControlSystem system = new ElevatorControlSystem();
        system.requestFloor(3, Direction.UP);
        system.requestFloor(5, Direction.UP);

    }
}
