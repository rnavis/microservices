package com.rnavis.basics.testlearning;

public class CustomSingleton {
    private static CustomSingleton INSTANCE;
    private CustomSingleton(){
        System.out.println("create Instance");
    }
    public static CustomSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized ((CustomSingleton.class)) {
                if (INSTANCE ==null)
                    INSTANCE =  new CustomSingleton();
            }
        }
        return INSTANCE;
    }
}

class TestSingleton {
    public static void main(String args[]) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                CustomSingleton test = CustomSingleton.getInstance();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                CustomSingleton test = CustomSingleton.getInstance();
            }
        });

        t1.start();
        t2.start();
    }
}
