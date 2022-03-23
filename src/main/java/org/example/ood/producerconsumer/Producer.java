package org.example.ood.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer  implements Runnable{
    BlockingQueue<Integer> q;
    public Producer(BlockingQueue<Integer> q){
        this.q = q;
    }

    @Override
    public void run() {
        for(int i=0; i < 5; i++){
            q.add(i);
            System.out.println("Produced:: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
