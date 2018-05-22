package com.rnavis.basics.brushup;

interface  IVase {
    void call();
    default void message() {
        System.out.println("all should msg");
    }

    default void watch() {
        System.out.println("all should watch");
    }
    static void forAll() {
        System.out.println("game on for static");
    }

    static void forAllNow() {
        System.out.println("game on for static now");
    }

}
class Indi {
    public void watch() {
        System.out.println("Indid...");
    }
}
interface ICase {
    void call();
    default void message() {
        System.out.println("icas all should msg");
    }

    default void watch() {
        System.out.println("icase all should watch");
    }
}
public class J8 extends Indi implements IVase, ICase {
    @Override
    public void call() {
        System.out.println("Vasse call");
    }

    @Override
    public void message() {
        System.out.println("Vasse msge");
        IVase.super.message();
    }

    public static void main(String args[]) {
        /*Vase v = new Vase();
        v.watch();
        v.message();*/
    }

}

class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
}

