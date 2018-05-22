package com.rnavis.basics.brushup;

public class ReverseAString {
    public static void main(String args[]) {
        try {
            System.out.println(new Integer(3000).equals(new Integer(3000)));
            System.out.println(500 == new Integer(500));//false
            System.out.println(new String("abbb").equals(new String("abbb")));//false
        }finally {
            System.gc();
        }
    }
    /*

    public static void main(String args[]) {
        System.out.println(14/5);
        String str=  "abcd";
        */
/**
         * o(n)
         *//*

        char[] chars = str.toCharArray();
        for(int i=chars.length-1;i>=0;i--) {
            System.out.print(chars[i]);
        }
        System.out.println();
        */
/*
        o(n/2)
         *//*

        char a,b;
        int i=0;
        int j=chars.length-1;
        while(i<=(chars.length-1)/2) {
            a = chars[i];
            b=chars[j];
            chars[i] = b;
            chars[j] = a;
            i++;
            j--;
        }
        for (char c:chars) {
            System.out.print(c);
        }
    }
*/
}
