package com.rnavis.basics.testlearning;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    public static void main(String args[]) throws Exception {
        Worker worker = new Worker(new ArrayBlockingQueue(5));
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.add();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.remove();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

    }
}

class Worker {

    ArrayBlockingQueue queue;
    Worker(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    public void add() throws Exception{
        int counter = 0;
        while(true) {
            System.out.println("put "+counter);
            queue.put(counter);
            counter++;
            Thread.sleep(1000);
        }
    }
    public void remove() throws Exception {
        while(true) {
            System.out.println("Removed" +(Integer) queue.take());
            Thread.sleep(1000);
        }
    }
}