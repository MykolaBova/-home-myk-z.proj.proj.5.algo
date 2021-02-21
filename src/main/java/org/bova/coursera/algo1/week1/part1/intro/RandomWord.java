package org.bova.coursera.algo1.week1.part1.intro;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {

        String currentString;
        String resultingString = "";
        int i = 1;

        while (!StdIn.isEmpty()) {

            boolean toAssign = StdRandom.bernoulli((double) 1 / i);
            currentString = StdIn.readString();

            if (toAssign) {
                resultingString = currentString;
            }
            i++;
        }

        if (!resultingString.isEmpty()) {
            StdOut.println(resultingString);
        }
    }
}
