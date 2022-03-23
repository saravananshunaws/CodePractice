package org.example.certify;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Task implements Runnable{
    CyclicBarrier cyclicBarrier;
    public Task( CyclicBarrier cyclicBarrier ){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println("Executing Thread " + Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Finished Executing Thread " + Thread.currentThread().getName());
    }
}

public class CyclicBarrierMain {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, ()->{
            System.out.println("Barrier Ended");
        });

        Thread t1 = new Thread(new Task(cyclicBarrier));
        //t1.start();
        System.out.println("Program Ended");
    }
}
