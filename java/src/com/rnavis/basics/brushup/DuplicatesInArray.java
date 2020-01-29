package com.rnavis.basics.brushup;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicatesInArray {
    public static void main(String args[]) {
        String[] arr = {"time", "money", "tim", "act","zoo","kite", "money", "zoo", "act", "tim", "round", "tim"};

        /** using collections **/
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(" , ")));
        String[] withoutDups = removeDuplicatesUsingCollections(arr);
        System.out.println(Arrays.stream(withoutDups).collect(Collectors.joining(" , ")));

        /** without using collections **/
        String[] withoutDupsWithoutcollections = removeDuplicatesWithoutCollections(arr);
        System.out.println(Arrays.stream(withoutDupsWithoutcollections).collect(Collectors.joining(" , ")));

    }

    public static String[] removeDuplicatesWithoutCollections(String[] array) {

        Arrays.sort(array);
        System.out.println("After sort => " +Arrays.stream(array).collect(Collectors.joining(" , ")));
        int count =1;
        for (int i=1; i<array.length;i++) {
            if (array[i] != array[i-1]) {
                count++;
            }
        }
        String[] newarr = new String[count];
        int n = 1;
        newarr[0] = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i] != array[i-1]) {
                newarr[n] = array[i];
                n++;
            }
        }
        return newarr;
    }

    public static String[] removeDuplicatesUsingCollections(String[] array) {
        Set<String> set = new LinkedHashSet<>();
        for (String s: array) {
            set.add(s);
        }
        return set.toArray(new String[set.size()]);

    }

}
