package com.rnavis.basics.testlearning;


import java.util.LinkedList;

public class PCProblem {

    public static void main(String args[]) throws Exception {
        PCWorker worker = new PCWorker(5);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.remove();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class PCWorker {

    LinkedList list = new LinkedList();
    int limit;
    PCWorker(int limit) {
        this.limit = limit;
    }
    public void add()  throws Exception {
        int i =0;
        while(true) {
            synchronized (this) {
                while (list.size() >= limit) {
                    wait();
                }
                int added = i++;
                list.add(added);
                System.out.println("Adding =" + added + " Size after add =" + list.size());
                notify();
                Thread.sleep(3000);
            }
        }
    }
    public void remove() throws Exception {
        while(true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                System.out.println("removed = " + list.remove() + "  Size after removal = "+list.size());
                notify();
                Thread.sleep(3000);
            }
        }
    }

}