package org.bova.hackerrank.compete.euler.euler1;

/*
https://projecteuler.net/problem=1

https://projecteuler.net/

Mykola_Bova_2
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {

    private static Map<Integer, Integer> results = new HashMap<>();

    public static void printNumbers(int n) {

        int sum = 0;
        Integer result = results.get(n);

        if(result == null) {
            for (int i = 0; i < n; i++) {
                if(i % 3 == 0 || i % 5 == 0) {
                    sum += i;
                    //System.out.println(i);
                }
            }
            results.put(n, sum);
        } else {
            sum = result;
        }

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
