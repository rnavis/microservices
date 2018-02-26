package com.rnavis.basics.brushup;

public class LcmGcd {

    public static void main(String args[]) {
        FindLcm findLcm = new FindLcm();
        findLcm.brute_lcm(4,5);
        findLcm.brute_lcm(4,0);
        findLcm.brute_lcm(27,9);
        findLcm.brute_lcm(27,9,0);
        findLcm.brute_lcm(27,9,33);
        FindGcd findGcd = new FindGcd();
        //findGcd.gcd_brute(32,600);
        findGcd.gcd_euclidean(27,9);
        findGcd.gcd_euclidean(33,120);
        findLcm.lcmByGCD(27, 9);
        findLcm.lcmByGCD(9,27);
        findLcm.lcmByGCD(458, 995);
        findLcm.lcmByGCD(180, 99);

        TestNode n1 = new TestNode(3,5);
        TestNode n2 = new TestNode(9,15);
        System.out.println(n1.toString() + "+" + n2.toString() +" = ");
        TestNode sum = new FindSumOfFraction().sumOfFraction(n1, n2);
        System.out.println(sum.toString());
    }
}
class FindGcd {
    /**
     * Brute force, take lowest of the 2,
     * find the highest number from 0 to lowest which is
     * divisible by both a and b
     */
    void gcd_brute(int a, int b) {
        if (a == 0 || b == 0) {
            System.out.println("one of the value is 0, gcd = 0");
            return;
        }
        int gcd = a>b ? b:a;
        while(gcd>0) {
            if (a % gcd ==0 && b % gcd ==0) {
                System.out.println("GCD ="+ gcd);
                break;
            }
            gcd--;
        }
        if (gcd ==0)
            System.out.println("GCD not found so, gcd = 1");
    }

    /**
     * Euclidean algo
     * gcd(a,b)
     * a> b ?
     * a = b *x + y
     * b = y *p + q
     * ...
     * recursively run gcd of (a mod b and b)
     * if b equals 0, the a is the gcd, if a equals 0, b is the gcd
     */
    int gcd_euclidean(int a, int b) {
        if (a == 0) {
            System.out.println("GCD = "+b);
            return b;
        } else if (b == 0) {
            System.out.println("GCD = "+a);
            return a;
        }

        if (a>b) {
            return gcd_euclidean(a%b, b);
        } else {
            return gcd_euclidean(a, b%a);
        }
    }
}
class FindLcm {
    void brute_lcm(int a, int b) {
       if (a == 0 || b == 0) {
           System.out.println("one of the value is 0");
           return;
       }
       int lcm = a> b ? a : b;
       while (true) {
           if (lcm % a ==0 && lcm % b == 0) {
               System.out.println("lcm = "+lcm);
               break;
           }
           lcm++;
       }
    }
    void brute_lcm(int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) {
            System.out.println("one of the value is 0");
            return;
        }
        int lcm = a> b ? a>c ? a: c : b > c ? b:c;
        while (true) {
            if (lcm % a ==0 && lcm % b == 0 && lcm % c == 0) {
                System.out.println("lcm = "+lcm);
                break;
            }
            lcm++;
        }
    }

    int lcmByGCD(int a, int b) {
        int gcd;
        gcd =gcd(a, b);
        int lcm = (a * b ) / gcd;
        System.out.println("LCM =" +lcm);
        return lcm;
    }
    int gcd(int a, int b) {
        if (a ==0) {
            return b;
        } else if (b ==0) {
            return a;
        }
        if (a>b) {
            return gcd(a%b, b);
        } else {
            return gcd(a, b%a);
        }
    }

}


class FindSumOfFraction {
    TestNode sumOfFraction(TestNode n1, TestNode n2) {
        FindGcd gcd = new FindGcd();
        FindLcm lcm = new FindLcm();
        int sumDenominator = lcm.lcmByGCD(n1.denominator, n2.denominator);
        int l1 = sumDenominator/ n1.denominator * n1.numerator;
        int l2 = sumDenominator/ n2.denominator * n2.numerator;
        int sumNumerator = l1+l2;
        int calcGcd = gcd.gcd_euclidean(sumNumerator, sumDenominator);
        return new TestNode(sumNumerator/calcGcd, sumDenominator/calcGcd);
    }
}
class TestNode {
    int numerator;
    int denominator;
    TestNode(int numerator, int denominator) {
        this.numerator= numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return this.numerator+"/"+this.denominator;
    }
}


