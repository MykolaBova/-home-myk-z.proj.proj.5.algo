package org.bova.hackerrank.compete.euler.euler1;

/*
https://projecteuler.net/problem=1

https://projecteuler.net/

Mykola_Bova_2

https://www.xarg.org/puzzle/project-euler/problem-1/

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {

    private static Map<Integer, Integer> results = new HashMap<>();

    public static void printNumbers(int n) {

        int n1 = n - 1;

        double r = Math.floor(n1 / 3);
        double s = Math.floor(n1 / 5);
        double t = Math.floor(n1 / 15);

        double sum =  0.5 * (
                3 * r * (r + 1)
                        +  5 * s * (s + 1)
                        - 15 * t * (t + 1));

        System.out.println((long)sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            printNumbers(n);
        }
    }
}
