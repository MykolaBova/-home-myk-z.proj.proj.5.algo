package org.bova.hackerrank.interview.warmup.repeatedstring;

/*
OUTPUT_PATH
/home/myk/z.proj.proj.4.algo/getting-started/src/main/java/org/bova/hackerrank/interview/warmup/repeatedstring/out.txt

 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        char c;
        long l = s.length();
        long repeatedA = 0L;

        long numAinSubstring = 0;
        for (int i = 0; i < l; i++) {
            c = s.charAt(i);
            if(c == 'a' || c == 'A') {
                numAinSubstring++;
            }
        }

        long numOfSubstrings = n / s.length();
        long numOfRest = n % s.length();
        long numOfAInRest = 0;

        for (int i = 0; i < numOfRest; i++) {
            c = s.charAt(i);
            if(c == 'a' || c == 'A') {
                numOfAInRest++;
            }
        }

        return numAinSubstring * numOfSubstrings + numOfAInRest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
