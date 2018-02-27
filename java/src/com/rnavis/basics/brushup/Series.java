package com.rnavis.basics.brushup;

public class Series {

    public static void main(String args[]) {
        fiboSeries(150);
    }
    static void fiboSeries(int limit) {
        int i =0;
        int j=1;
        System.out.print(i + " "+ j);
        while (i+j<150) {
            int temp= i+j;
            i = j;
            j = temp;
            System.out.print(" "+temp);
        }
    }
}
