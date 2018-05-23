package com.rnavis.basics.brushup;

public class Amstrong {
    public static void main(String args[]) {
        /**
         * With Math func
         */
        isAmstrongWithPow("146511208");
        /**
         * without math func
         */
        isAmstrongWithoutMathFunc("146511208");
    }

    public static void isAmstrongWithoutMathFunc(String numString) {
        int pow= numString.length();
        try {
            Integer number = Integer.parseInt(numString);
            int temp = number;
            int totalsum=0;
            int val=0;
            while(number!=0) {
                val = number%10;
                number = number/10;
                int sum = val;
                for(int i=0;i<pow-1;i++) {
                    sum *=val;
                }
                totalsum+=sum;

            }
            if (totalsum == temp) {
                System.out.println(numString + " is an Amstrong number " + "Sum is=" + totalsum);
            } else
                System.out.println(numString + " is not an Amstrong number " + "Sum is=" + totalsum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public static void isAmstrongWithPow(String numString) {
        try {
            int pow = numString.length();
            Integer number = Integer.parseInt(numString);
            int input = number;
            int sum = 0;
            while (number != 0) {
                int val = number % 10;
                number = number / 10;
                sum += new Double(Math.pow((double) val, (double) pow)).intValue();
            }

            if (sum == input) {

                System.out.println(numString + " is an Amstrong number " + "Sum is=" + sum);
            } else
                System.out.println(numString + " is not an Amstrong number " + "Sum is=" + sum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
