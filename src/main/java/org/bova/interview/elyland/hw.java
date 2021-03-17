package org.bova.interview.elyland;

/*
    https://www.coursera.org/learn/algorithms-part1/home/welcome
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class hw {

    /*
    input - 2 sorted list if int
    result - sorted list containing both lists
        with duplicated

        l1
        1 2  4  9


        l2

        3  4  10

        LO

        1 2 3 4 4 9 10

     */


    public static List mergeSortedLists(List<Integer> l1, List<Integer> l2) {

        AtomicInteger ai = new AtomicInteger();
        ai.set(1);
        int ii = ai.incrementAndGet();

        int n = l1.size();
        int m = l2.size();

        List<Integer>  output = new ArrayList<>();

        for(int i = 0; i < n;) {
            for(int j = 0; j < m;) {
                if(i < n && l1.get(i) < l2.get(j)) {
                    output.add(l1.get(i));
                    System.out.println("Added output element = " + l1.get(i) + ", i = " + i);
                    i++;
                } else {
                    output.add(l2.get(j));
                    System.out.println("Added output element = " + l2.get(j) + ", j = " + j);
                    j++;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");


        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        l1.add(9);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        l2.add(10);


        mergeSortedLists(l1, l2);


    }
}
