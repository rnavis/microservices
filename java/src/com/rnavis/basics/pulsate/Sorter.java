package com.rnavis.basics.pulsate;

import java.util.Arrays;

public class Sorter {
    public static void main(String args[]) {
        BubbleUp bubbleUp = new BubbleUp();
        System.out.println(Arrays.toString(bubbleUp.array));
        System.out.println("after sort...");
        bubbleUp.sort();
        System.out.println(Arrays.toString(bubbleUp.array));
    }
}

/**
 * #1 loop through all elements in the array
 * #2 for every element, loop back again
 * #3 if the element > next element, then switch using a testlearning
 * #4 in place sort
 */
class BubbleUp {
    int[] array = {9,5,2,8,3,9,1,4,7};
    void sort() {
        int temp=0;
        for (int i=0; i<array.length-1;i++) {
            for (int j=0; j<array.length-1-i;j++) {
                temp = array[j];
                if (array[j] > array[j+1]) {
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
