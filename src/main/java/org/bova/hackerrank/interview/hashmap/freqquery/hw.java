package org.bova.hackerrank.interview.freqquery;

/**
 * Problem Statement-
 * Task https://www.hackerrank.com/challenges/count-triplets-1/problem
 * Code -
 * Slides -
 * Video - https://www.youtube.com/watch?v=al5mvHLbCb4
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw {
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
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for(List<Integer> query : queries) {

            Integer command = query.get(0);
            Integer commandParameter2 = query.get(1);

            switch (command) {
                case 1:
                    map.put(commandParameter2, map.getOrDefault(commandParameter2, 0) + 1);
                    break;
                case 2:

                    Integer frequency = map.get(commandParameter2);
                    if(frequency != null) {
                        if(frequency != 0) {
                            map.put(commandParameter2, map.get(commandParameter2) - 1);
                        } else {
                            map.remove(commandParameter2);
                        }
                    }

                    break;
                case 3:

                    /*
                        <frequency, List<value, value>>
                            map.conatins(frequency)

                         insert
                            <frequency, List<value, value>>
                                get List<value, value>
                                add new frequency to the list

                                map
                            1 1 2
                            2 3

                                query
                            insert 2
                                map
                            1 1 2
                                <- remove 2 from here
                            2 3
                                <- add 2 here
                     */
                    int result = 0;
                    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

                        if(entry.getValue() == commandParameter2) {
                            result = 1;
                            break;
                        }
                    }
                    results.add(result);
                    break;
                default:
                    break;
            }

        }

        return results;
    }
}
