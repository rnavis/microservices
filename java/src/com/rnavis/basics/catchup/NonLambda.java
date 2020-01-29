package com.rnavis.basics.catchup;

public class NonLambda {

    public void greet(Greet greet) {
        greet.performGreet();
    }
    public static void main(String args[]) {
        NonLambda nonLambda = new NonLambda();
        Greeter greeter = new NonLambda().new Greeter();
        nonLambda.greet(greeter);

        Greet myLambdaExpress = () -> System.out.println("dai");
        nonLambda.greet(() -> System.out.println("hai"));

        nonLambda.greet(myLambdaExpress);

        Add addFunction = (a,b) -> a + b;
        long result = addFunction.add(4,5);
        System.out.println(result);
    }

    class Greeter implements Greet {

        @Override
        public void performGreet() {
            System.out.println("Hai everyone");
        }
    }


}
interface Greet {
    void performGreet();
}
interface Add {
    long add(long a, long b);
}

