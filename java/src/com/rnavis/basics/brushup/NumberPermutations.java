package com.rnavis.basics.brushup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPermutations {

    public static void main (String args[]) {
        int[] a = {1,2,3};
        List<int[]> results = new ArrayList<>();
        permuations(a, 0, results);

        System.out.println("count "+ results.size());
        System.out.println("for " + a + " NumberPermutations are: ");
        for (int[] x: results) {
            System.out.println(Arrays.toString(x));
        }
    }

    public static void permuations(int[] a, int start, List<int[]> results) {

        if (start >=a.length) {
            results.add(a.clone());
            return;
        } else {
            for (int i=start; i<a.length;i++) {
                swap(a, start, i);
                permuations(a, start+1, results);
                swap(a, start, i);
            }
        }

    }

    public static void swap(int[] a, int i, int j) {
       int temp = a[i];
       a[i] = a[j];
       a[j] = temp;
    }
}
