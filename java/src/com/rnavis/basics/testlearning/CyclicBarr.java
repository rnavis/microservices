package com.rnavis.basics.testlearning;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarr {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            private int count = 1;
            @Override
            public void run() {
                System.out.println("Completed..!! " + (count++));
            }
        });
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(new CuclicBarThread(barrier));
            t.start();
        }
    }
}

class CuclicBarThread implements Runnable {

    CyclicBarrier barrier;

    public CuclicBarThread(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 5; i++) {
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName() + " :: Waiting At Barrier 1 After Stage 1 Completed");
            barrier.await();

            for (int i = 1; i < 5; i++) {
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + " :: Waiting At Barrier 2 After Stage 2 Completed");
            barrier.await();

            for (int i = 1; i < 5; i++) {
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName() + " :: Waiting At Barrier 3 After Stage 3 Completed");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " :: $$$$$$$$ Completed $$$$$$$$");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
