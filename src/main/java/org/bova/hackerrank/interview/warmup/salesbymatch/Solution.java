package org.bova.hackerrank.interview.warmup.salesbymatch;

/*
  export OUTPUT_PATH=/home/myk/z.proj.proj.4.algo/getting-started/src/main/java/org/bova/hackerrank/interview/warmup/salesbymatch/out.txt
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Integer> socksByColor = new HashMap();

        for (int i = 0; i < n; i++) {
            Integer count = socksByColor.get(ar[i]);
            count = count == null ? 1 : Integer.valueOf(++count);
            socksByColor.put(ar[i], count);
        }

        int pairs = 0;
        for (Integer value : socksByColor.values()) {
            pairs += value / 2;
        }

        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
