package org.bova.hackerrank.interview;

/**
 * Problem Statement-
 * Task https://www.hackerrank.com/challenges/count-triplets-1/problem
 * Code -
 * Slides -
 * Video - https://www.youtube.com/watch?v=al5mvHLbCb4
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Long> arr = new ArrayList<>();

        arr.add(1L);
        arr.add(2L);
        arr.add(2L);
        arr.add(4L);

        countTriplets(arr, 2);
    }

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
}
