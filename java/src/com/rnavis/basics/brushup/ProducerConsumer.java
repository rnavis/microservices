package com.rnavis.basics.brushup;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    public static void main(String args[]) {
        ProducerConsumer pc = new ProducerConsumer();
        /**
         * With Blocking Queue
         */
        System.out.println("====================");
        //pc.testWithBlockingQueue();
        /**
         * With wait notify
         */
        System.out.println("====================");

        Thread producer = new Thread(new Runnable()  {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(new Runnable()  {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                }
            }
        });
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch(InterruptedException ee) {

        }

    }



    public void consumer() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Stared consuming...");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            System.out.println("Consumed....");
            notify();
        }
    }


    public void producer() throws InterruptedException {
        synchronized (this) {
            for (int i=0;i<10;i++) {
                System.out.println("Produced "+ i);
                wait();
                System.out.println("Resumed to produce...");
            }
        }
    }

    public void testWithBlockingQueue () {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        Thread producer = new Thread(new Runnable() {
            Random random = new Random();

            @Override
            public void run() {
                while (true) {
                    try {
                        Integer add = random.nextInt(15);
                        System.out.println("Adding "+ add + " Queue Size "+ queue.size());
                        queue.put(add);

                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            Random random = new Random();

            @Override
            public void run() {
                while (true) {
                    try {
                        if (random.nextInt(1000) == 10) {
                            Integer taken = queue.take();
                            System.out.println("Value taken " + taken + "Queue Size " + queue.size());
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
