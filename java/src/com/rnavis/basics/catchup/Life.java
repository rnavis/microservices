package com.rnavis.basics.catchup;

//nested class can be instantiated and called from instance of parent class

public class Life {
    public static void main(String args[]) {
        Life life = new Life();
        life.live();
        Person person2 = life.new Person();
        person2.live("static ref person");

        Animal animal = new Animal();
        animal.live2("dog");
        Animal.live("cat");
    }

    public void learn() {
        System.out.println("life learn");
    }

    private void live() {
        System.out.println("life to live");
        Person person = new Person();
        person.live("instance person");
        Animal animal = new Animal();
        animal.live2("another dog");
        Animal.live("another cat");
        Animal.live("static dog");
    }

    final class Beast {

        protected void live(String who) {
            System.out.println("beast live "+who);
        }
    }

    final class Person {
        private Person(){}

        private void live(String who) {
            System.out.println("person live "+who);
        }
    }

    static class Animal {
        static void live(String who) {
            System.out.println("animal live "+who);
        }
        void live2(String who) {
            System.out.println("insance animal live "+who);
        }
    }
}

class Universe {
    public static void main(String args[]) {
        Life life = new Life();
        //Life.Person person = life.new Person();// outer class does not have access to private constructor class but nested classes do!
        Life.Beast beast = life.new Beast();
        beast.live("ravan");
        Universe universe = new Universe();
        universe.galaxy("andromeda");
        Metal metal = new Universe().new Metal();
        metal.isMalleable("static ref");
    }
    void galaxy (String who) {
        System.out.println("galaxy "+ who);
        //Metal2 metal2 = new Metal2();// cant access
        Metal metal = new Metal();// can only access a inner private class
        metal.isMalleable("instance ref");
    }

    class Metal {
        private Metal() {

        }
        private boolean isMalleable(String who) {
            System.out.println("is malleable "+ who );
            return 1==1;
        }
    }

}

class Metal2 {

    public static void main(String args[]) {
        Life.Animal animal = new Life.Animal();
        animal.live2("dragon");
        Life life = new Life();
        life.learn();

        Life life2 = new Life() {
            public void learn() {
                System.out.println("anonymous learn");
            }
            private void test() {
                System.out.println("private test");
            }
        };
        life2.learn();


    }
}

