package org.bova.hackerrank.interview.hashmap.anagrampairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int n = s.length();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                char[] c = s.substring(i, j+1).toCharArray();
                Arrays.sort(c);
                String k = new String(c);

                if(map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 1);
                }
            }

        }

        int anagramPairs = 0;

        for(String k : map.keySet()) {
            int v = map.get(k);

            anagramPairs += (v * (v - 1)) / 2;
        }

        return anagramPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
