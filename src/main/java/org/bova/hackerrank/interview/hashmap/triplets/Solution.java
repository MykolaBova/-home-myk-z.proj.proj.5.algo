package org.bova.hackerrank.interview.hashmap.triplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    private static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();

        // fill rightMap
        for (long item : arr) {
            rightMap.put(item, rightMap.getOrDefault(item, 0L) + 1);
        }

        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);
            long countLeft = 0;
            long countRight = 0;;

            // decrement count of a[i] in rightMap to take in account processing current element
            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);

            // get frequency od a[i]/r elements from leftMap
            // 1 in case if it exists
            // 2 in case if it a[i] cane be divided to r without reminder
            if (leftMap.containsKey(midTerm / r) && midTerm % r == 0) {
                countLeft = leftMap.get(midTerm / r);
            }

            if (rightMap.containsKey(midTerm * r))
                countRight = rightMap.get(midTerm * r);

            // calculate count of triplets setting current to a current element
            count += countLeft * countRight;

            // increment count of a[i] in leftMap to take in account processing current element
            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

