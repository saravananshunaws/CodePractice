package org.example.design.elevator.v2;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;

@Data
public class ElevatorControlSystem {
    PriorityQueue<ElevatorRequest> upQueue;
    PriorityQueue<ElevatorRequest> downQueue;
    List<Elevator> elevatorList;

    public ElevatorControlSystem(List<Elevator> elevatorList) {
        this.elevatorList = elevatorList;
        upQueue = new PriorityQueue<>(Comparator.comparingInt(ElevatorRequest::getFloor));
        downQueue = new PriorityQueue<>((a, b) -> b.getFloor() - a.getFloor());
        CompletableFuture.supplyAsync(() -> processUpQueue());
        CompletableFuture.supplyAsync(() -> processDownQueue());
    }

    public void requestFloor(Direction direction, int floor) {
        if (direction == Direction.UP) {
            ElevatorRequest request = new ElevatorRequest(direction, floor);
            upQueue.add(request);

        } else if (direction == Direction.DOWN) {
            ElevatorRequest request = new ElevatorRequest(direction, floor);
            downQueue.add(request);
        }
    }

    public int processUpQueue() {
        System.out.println("Starting processUpQueue() ");
        while (true) {
            if (upQueue.isEmpty()) {
                try {
                   Thread.sleep(1500);
                    continue;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("up queue :: " + upQueue);
            if (!upQueue.isEmpty()) {
                ElevatorRequest elevatorRequest = upQueue.poll();
                Elevator elevator = chooseBestElevator(elevatorRequest.getDirection(), elevatorRequest.getFloor());
                System.out.println("Requesting UP Elevator :: " + elevator);
                elevator.moveUp(elevatorRequest.getFloor());
            }
        }
    }

    public int processDownQueue() {
        System.out.println("Starting processDownQueue() ");
        while (true) {
            if (downQueue.isEmpty()) {
                try {
                    Thread.sleep(1500);
                    continue;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("down queue :: " + downQueue);
            if (!downQueue.isEmpty()) {
                ElevatorRequest elevatorRequest = downQueue.poll();
                Elevator elevator = chooseBestElevator(elevatorRequest.getDirection(), elevatorRequest.getFloor());
                System.out.println("Requesting Down Elevator :: " + elevator);
                elevator.moveDown(elevatorRequest.getFloor());
            }
        }
    }


    public Elevator chooseBestElevator(Direction direction, int floor) {
        Elevator bestElevator = elevatorList.get(0);
        for (Elevator elevator : elevatorList) {
            if (elevator.getCurrentFloor() > floor && direction == Direction.DOWN) {
                bestElevator = elevator;
            } else if (elevator.getCurrentFloor() < floor && direction == Direction.UP) {
                bestElevator = elevator;
            }else{
                bestElevator = elevator;
                break;
            }
        }
        return bestElevator;
    }
}
