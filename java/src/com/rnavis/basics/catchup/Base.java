package com.rnavis.basics.catchup;

public class Base {
 public static void main(String arg[]) {

  System.out.println(128 == 128);
  System.out.println("---------------");
  int i = 128;
  System.out.println(i == 128);

  int j =128;
  System.out.println(j == i);

  Integer a = 128;
  System.out.println(a == 128);

  Short p = 128;
  Short q = 128;
  System.out.println(p == q);

  System.out.println("****************");

  short x = 32767;
  short y = 32767;
  System.out.println(x == y);
 }
}
