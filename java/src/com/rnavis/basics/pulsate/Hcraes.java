package com.rnavis.basics.pulsate;

import java.util.Arrays;

public class Hcraes {

    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();
        bs.search(1);
    }
}
class BinarySearch{
    int[] array = {8, 4,13,9,11, 2, 15,7,5,21,3};
    void search(int value) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int start =0;
        int end = array.length-1;
        while (start<=end) {
            int mid  = (start + end)/ 2;
            if (value == array[mid]){
                System.out.println("found matching "+ value);
                break;
            }
            if (value<array[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        if (start>end) {
            System.out.println("no match found");
        }
    }
}
