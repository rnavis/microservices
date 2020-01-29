package com.rnavis.basics.testlearning;

import java.util.Arrays;

public class Quiz {

    public static void main(String args[]) {
        //String input = "Aerate pet area";
        //System.out.println(input + "- is palindrome "+ isPalindrome(input));
        String input = "maackupto";
        System.out.println(removedString(input,"t"));
    }

    static String removedString(String input, String a) {
        if (a.length()>1) {
            System.out.println("need to learn !!");
            return input;
        }
        char[] inputChar = input.toCharArray();
        int count =0;
        for (int i=0;i<=inputChar.length-1;i++) {
            if (inputChar[i] != a.charAt(0))
                count++;
        }
        char[] outChars = new char[count];

        count =0;
        for (int i=0;i<inputChar.length;i++) {
            if (inputChar[i] != a.charAt(0)) {
                outChars[count] = inputChar[i];
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: outChars) {
            sb.append(c);
        }
        return sb.toString();
    }

    static boolean isPalindrome(String input) {
        char[] inputChars = input.toLowerCase().replaceAll("\\W+","").toCharArray();
        int mid = inputChars.length/2;
        int i =0;
        int j = inputChars.length-1;

        while(j>=mid) {
            if (inputChars[i] == inputChars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
