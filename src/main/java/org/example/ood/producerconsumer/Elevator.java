package org.example.ood.producerconsumer;

import lombok.Getter;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.concurrent.Flow;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
@Setter
public class Elevator<T> implements Flow.Subscriber<T> {
    private long id;
    private int currentFloor;
    private ElevatorControlSystem.Direction direction;
    private Queue<Integer> current = new LinkedBlockingQueue<>();
    private Flow.Subscription subscription;

    public Elevator(){
        currentFloor = 0;
        direction = ElevatorControlSystem.Direction.NONE;
    }

    public void goToFloor() throws InterruptedException {
        int floor = current.poll();
        this.currentFloor = floor;

        Thread.sleep(1000);
    }

    public void run() {
        try {
            while (true) {
                if (current.isEmpty()) {
                    Thread.sleep(5000);
                }else {
                    goToFloor();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println("Got : " + item);
       // consumedElements.add(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
