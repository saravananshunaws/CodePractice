package org.example.threads;

import java.util.*;

public class InterThreadCommunication {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    public synchronized void produce(){
        try{
            int value = 0;
            while (true) {

                while (list.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced-" + value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public synchronized  void consume(){
        try{
            while (true) {

                while (list.size() == 0) {
                    wait();
                }

                int val = list.removeFirst();
                System.out.println("Consumer consumed-"  + val);

                notify();
                Thread.sleep(1000);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        InterThreadCommunication ic = new InterThreadCommunication();

        Runnable r1 = () -> {
            ic.produce();
        };

        Runnable r2  = () -> {
            ic.consume();
        };

        Thread t1 =  new Thread(r1);
        Thread t2 =  new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
