package org.bova.hackerrank.interview.warmup.jumpingontheclouds;

/*
OUTPUT_PATH
/home/myk/z.proj.proj.4.algo/getting-started/src/main/java/org/bova/hackerrank/interview/warmup/jumpingontheclouds/out.txt

 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int n = c.length;
        int steps = 0;

        for(int i = 0; i < n;) {
            if(i + 2 < n && c[i + 2] == 0) {
                steps++;
                i = i + 2;
            } else if (i + 1 < n && c[i + 1] == 0) {
                steps++;
                i = i + 1;
            } else {
                break;
            }
        }

        return steps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}