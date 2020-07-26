/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.certification.java;

import java.util.Scanner;

/*
 Write the Adder class here. Do not use an access modifier at the beginning of your class declaration.
 */
public class CalCulate {
    public static void main(String[] args) {
        int a, b;
        try (Scanner scan = new Scanner(System.in)) {
            a = scan.nextInt();
            b = scan.nextInt();
        }
        Calculator adderObject = new Adder();
        System.out.println("The sum is: " + adderObject.add(a, b));
    }
}

abstract class Calculator {
    abstract int add(int a, int b);
}

class Adder extends Calculator {
    int add(int a, int b) {
        return a + b;
    }
}

