package org.bova.hackerrank.interview.freqquery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
///////////////// General approach

    <frequency, List<value, value>>
    frequencyMap.conatins(frequency)

    insert
    <frequency, List<value, value>>
        get List<value, value>
        add new frequency to the list

        frequencyMap
    1   1 2
    2   3

        indexMap
    1   1
    2   1
    3   2

        query
    insert 2
        frequencyMap
    1 1 2
        <- remove 2 from here
        if frequencies list is empty -> remove entry from frequencyMap?
            or return empty list (to double check)
    2 3
        <- add 2 here

///////////////// INSERT

    valueIndexMap
    1   1
    2   1
    3   2

    frequencyMap
    1  1,2
    2  3

    **** insert 1

    valueIndexMap
    1   2
    2   1
    3   2

    frequencyMap
    1  2
    2  3,1

///////////////// DELETE

    valueIndexMap
       1   2
       2   1
       3   2

    frequencyMap
       1  2
       2  3,1

    **** delete 1

    valueIndexMap
       2   1
       3   2

    frequencyMap
       1  2
       2  3
*/
public class hw1 {
    public static void main(String[] args) {
        System.out.println("Hello World!");

/*
3 4
2 1003
1 16
3 1
 */
//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(Arrays.asList(3,4));
//        queries.add(Arrays.asList(2,1003));
//        queries.add(Arrays.asList(1,16));
//        queries.add(Arrays.asList(3,1));


/*
    10
    1 3
    2 3
    3 2
    1 4
    1 5
    1 5
    1 4
    3 2
    2 4
    3 2
 */
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1,3));
        queries.add(Arrays.asList(2,3));
        queries.add(Arrays.asList(3,2));
        queries.add(Arrays.asList(1,4));
        queries.add(Arrays.asList(1,5));
        queries.add(Arrays.asList(1,5));
        queries.add(Arrays.asList(1,4));
        queries.add(Arrays.asList(3,2));
        queries.add(Arrays.asList(2,4));
        queries.add(Arrays.asList(3,2));

        freqQuery(queries);
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        Map<Integer, List<Integer>> frequencyMap = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for(List<Integer> query : queries) {

            Integer command = query.get(0);
            Integer commandParameter2 = query.get(1);

            Integer value;
            Integer frequency;
            Integer frequencyNew;
            List<Integer> valuesNew;

            switch (command) {
                case 1: // INSERT

                    value = commandParameter2;
                    frequency = valueIndexMap.get(value);
                    frequencyNew = frequency != null ? frequency + 1 : 1;

                    // Delete value from row in frequencyMap
                    if(frequency != null) {

                        List<Integer> values = frequencyMap.get(frequency);
                        if(values != null) {
                            values.remove(value);
                        }
                    }

                    // Add value from row in frequencyMap
                    valuesNew = frequencyMap.get(frequencyNew);
                    if(valuesNew != null) {

                        valuesNew.add(value);
                    } else {

                        valuesNew = new ArrayList<>();
                        valuesNew.add(value);
                        frequencyMap.put(frequencyNew, valuesNew);
                    }

                    // Update row in valueIndexMap
                    valueIndexMap.put(value, frequencyNew);

                    break;
                case 2: // DELETE

                    value = commandParameter2;
                    frequency = valueIndexMap.get(value);
                    frequencyNew = frequency != null ? frequency - 1 : null;

                    if(frequency != null) {

                        // Delete value from row in frequencyMap
                        List<Integer> values = frequencyMap.get(frequency);
                        if(values != null) {
                            values.remove(value);

                            if(values.size() == 0) {
                                frequencyMap.remove(frequency);
                            }
                        }

                        // Add value from row in frequencyMap
                        valuesNew = frequencyMap.get(frequencyNew);
                        if(valuesNew != null) {

                            valuesNew.add(value);
                        } else if(frequencyNew != 0) { // no need in row with frequency 0

                            valuesNew = new ArrayList<>();
                            valuesNew.add(value);

                            frequencyMap.put(frequencyNew, valuesNew);
                        }

                        // Update row in valueIndexMap
                        if(frequencyNew != 0) {
                            valueIndexMap.put(value, frequencyNew);
                        } else {
                            valueIndexMap.remove(value); // no need in row with frequency 0
                        }

                    } else {
                        // Do nothing - no way to delete not existing value
                    }

                    break;
                case 3:
                    int result = 0;
                    frequency = commandParameter2;
                    List<Integer> resultList = frequencyMap.get(frequency);

                    if(resultList != null) {
                        result = 1;
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
