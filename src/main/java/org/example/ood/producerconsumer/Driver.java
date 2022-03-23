package org.example.ood.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Driver {
    public static void main(String[] args) throws Exception{
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        new Thread(p).start();
        new Thread(c).start();

        //Thread.currentThread().join();
        System.out.println("Program Exited...... ");
    }
}
