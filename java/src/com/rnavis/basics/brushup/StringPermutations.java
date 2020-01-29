package com.rnavis.basics.brushup;

import java.util.*;

public class StringPermutations {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string " );
        String str = sc.next();

        char[] a = str.toCharArray();
        List<char[]> results = new ArrayList<>();

        permutations(a, 0, results);

        System.out.println("Count of permuations "+ results.size());
        System.out.println(" Permutations are ");
        results.stream().forEach(result -> System.out.println(Arrays.toString(result)));

    }

    public static void permutations(char[] a, int start, List<char[]> results) {

        if (start >= a.length) {
            results.add(a.clone());
            return;
        } else {
          for (int i=start; i<a.length;i++) {
              swap(a, start, i);
              permutations(a, start+1, results);
              swap(a, start, i);
          }
        }
    }

    public static void swap (char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
