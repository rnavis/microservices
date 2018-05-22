package com.rnavis.basics.brushup;

public class Inherit  {

    public static void main(String args[]) {

        A a = new A();
        B b = new B();
        C c = new C();
        X x = new X();
        //a = b; -- good
        //a = c; --> good
        //x= (X)a; - Compile time Exception
        I i = (I)a; // Runtime Exeption*****
        //b=a;//compile time exception
       // b=(B)a;//run time exception ******
    }

    public static void find(A a) {

        ((B)a).add();
    }
}

interface I{public void add();};
class A {void cadd() {System.out.println("A add");}};
class B extends A implements I {
    public void add() {
        System.out.println("add in B");
    }

};
class C extends B{public void add() {System.out.println("C add");}};
class X {void add() {System.out.println("X add");}};