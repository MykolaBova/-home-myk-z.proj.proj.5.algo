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

public class Solution3 {

    private static Map<Integer, Integer> results = new HashMap<>();

    public static void printNumbers(int n) {

        long x3 = (n-1)/3;
        long x5 = (n-1)/5;
        long x15 = (n-1)/15;

        long sum1 = 3*x3*(x3+1);
        long sum2 = 5*x5*(x5+1);
        long sum3 = 15*x15*(x15+1);

        long sum = (sum1+sum2-sum3)/2;
        System.out.println(sum);
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
