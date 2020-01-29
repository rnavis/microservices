package com.rnavis.basics.leetcode;

public class ReverseInteger {
    public static void main(String args[]) {
        ReverseInteger ri = new ReverseInteger();
        int x= 201;
        System.out.println(ri.reverse(x));

    }
    public int reverse(int y) {
        int x = y;
        StringBuilder sb = new StringBuilder();
        if (x==0) {
            return x;
        }
        while (x!=0) {
            sb.append(Math.abs(x%10));
            x = x/10;
        }
        long result=  Long.parseLong(sb.toString());
        if (result>Integer.MAX_VALUE || result <Integer.MIN_VALUE) {
            return 0;
        }
        if (y<0) {
            return (int)result * -1;
        }
        return (int)result;
    }
}

