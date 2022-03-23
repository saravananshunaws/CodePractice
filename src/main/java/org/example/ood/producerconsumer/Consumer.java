package org.example.ood.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<Integer> q;
    public Consumer(BlockingQueue<Integer> q){
        this.q = q;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Integer i = q.take();
                System.out.println("Consumed:: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
