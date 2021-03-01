package org.bova.hackerrank.interview.hashmap.freqquery;

/**
 https://github.com/hypersolid/competitive-programming/blob/master/hackerrank/algorithms/misc/Frequency-Queries.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw2_ {
    public static void main(String[] args) {
        System.out.println("Hello World!");

/*
3 4
2 1003
1 16
3 1
 */
        List<List<Integer>> queries = new ArrayList<>();

        queries.add(Arrays.asList(3,4));
        queries.add(Arrays.asList(2,1003));
        ///queries.add(Arrays.asList(2,1003));
        queries.add(Arrays.asList(1,16));
        queries.add(Arrays.asList(3,1));

        freqQuery(queries);
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int[] quantities = new int[queries.size() + 1];
        List<Integer> result = new ArrayList<>();
        int frequency, value;

        for (List<Integer> query : queries) {
            value = query.get(1);
            switch (query.get(1)) {
                case 1:
                    // process fq
                    frequency = frequencies.getOrDefault(value, 0);
                    frequencies.put(value, frequency + 1);
                    // process qt
                    quantities[frequency]--;
                    quantities[frequency + 1]++;
                    break;
                case 2:
                    // process fq
                    frequency = frequencies.getOrDefault(value, 0);
                    if (frequency == 0) break;
                    if (frequency == 1) frequencies.remove(value);
                    else frequencies.put(value, frequency - 1);
                    // process qt
                    quantities[frequency]--;
                    quantities[frequency - 1]++;
                    break;
                case 3:
                    if (value >= quantities.length) result.add(0);
                    else result.add(quantities[value] > 0 ? 1 : 0);
                    break;
            }
        }

        return result;
    }
}
