package com.rnavis.basics.catchup;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPerson {

    public static void main(String args[]) {
        List<Person> people = Arrays.asList(new Person("Ajai", "Karthik",20),
                new Person("Arun", "Kumar", 22),
                new Person("Jayant", "David", 25),
                new Person("Vishal", "Sukumar", 28),
                new Person("Ranjith", "Sivan", 20),
                new Person("Vikram", "Saran", 22),
                new Person("Vijay", "Emmanuel", 21),
                new Person("Washi", "Wangdu", 24),
                new Person("Wong", "Kim", 20),
                new Person("Parul", "Parli", 20),
                new Person("Prian", "Soragm", 25));

        // Step 1: Sort list by last name
        // Step 2: Create a method which prints all the elements in the list
        // Step 3: Create a list that lists all the people whose last name starts with S
        // Step 4: With Step 3 check also if the age is less than 25

        System.out.println("Before sort: ");
        people.forEach(person -> System.out.println(person.toString()));
        System.out.println("********************************************");
        System.out.println("********************************************");
        /*people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        */

        people.sort((p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
        System.out.println("After sort");
        people.forEach(person -> System.out.println(person.toString()));

        List<Person>filteredList = people.stream().filter(person -> isValidPerson(person, "S", 25)).collect(Collectors.toList());
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("Fitered list ");
        filteredList.forEach(person -> System.out.println(person.toString()));
    }

    private static boolean isValidPerson(Person person, String startWith, int ageLimit) {
        return person.getLastName().startsWith(startWith) && person.getAge()<=ageLimit;
    }
}
