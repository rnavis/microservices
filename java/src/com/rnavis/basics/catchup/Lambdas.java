package com.rnavis.basics.catchup;


public class Lambdas {

    public static void main(String args[]) {

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()  + " start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()  + " completed");
        };

        Thread thread = new Thread(runnable);

        thread.start();

    }
}