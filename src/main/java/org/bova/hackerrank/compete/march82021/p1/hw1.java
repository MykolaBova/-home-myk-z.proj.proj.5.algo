package org.bova.hackerrank.compete.march82021.p1;

/*
    https://www.coursera.org/learn/algorithms-part1/home/welcome
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class hw1 {
    public static void main(String[] args) {
//        System.out.println("Hello World!");

        List<Integer> numbers = new ArrayList<>();
//        numbers.add(3);
//        numbers.add(5);
//        numbers.add(8);


        numbers.add(10);
        numbers.add(13);
        numbers.add(5);
        numbers.add(18);


//        numbers.add(41);

//        int k = 1;
        int k = 3;

        getTopKBitDistances(numbers, k);
        
    }

    public static List<Integer> getTopKBitDistances(List<Integer> numbers, int k) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        //Map<>
        Map<Integer, TreeSet<Integer>> distanceMap =  new TreeMap<>(Collections.reverseOrder());

        System.out.println("k>>>" + k);
        System.out.println("numbers.num>>>" + numbers.size());
        System.out.println("numbers>>>");

        for(Integer number: numbers) {

//            System.out.println(number);

//            String binaryString = Integer.toBinaryStrin
//            g(number);
            String binaryString = String.format("%32s",
                    Integer.toBinaryString(number)).replaceAll(" ", "0");
//            System.out.println(binaryString);
            Integer distance = calculateDistamce(binaryString);

            TreeSet<Integer> storedSet = distanceMap.get(distance);
            if(storedSet == null) {
                storedSet = new TreeSet<>(Collections.reverseOrder());
                storedSet.add(number);
                distanceMap.put(distance, storedSet);
            } else {
                storedSet.add(number);
            }

        }

        System.out.println("keys>>>"+distanceMap.keySet());

        int resultCounter = 0;
//        for(Map.Entry<Integer, TreeSet<Integer>> entry : distanceMap.entrySet()) {
//
//
//        }

//        distanceMap.entrySet().for()

        for (Map.Entry<Integer, TreeSet<Integer>> integerTreeSetEntry : distanceMap.entrySet()) {

            for (Integer integer : integerTreeSetEntry.getValue()) {
                if(resultCounter >= k) {
                    break;
                }

                result.add(integer);
                resultCounter++;
            }
        }

        System.out.println("finish>>>");

        return result;
    }

    /*
    3
    5
    8

        3
00000000000000000000000000000011
    0

        5
00000000000000000000000000000101
    1

        8
00000000000000000000000000001000
    -1

00000000000000000000000000101001

     */
    static int calculateDistamce(String binaryString) {

        boolean firstOne = false;
        boolean secondOne = false;
        int distance = -1;
        int maxDistance = -1;

        /*
                firstOne = false
                secondOne = false

                0000101
                    ^

                firstOne = true
                secondOne = false

                0000101
                      ^
                firstOne = false
                secondOne = true

         */

        /*
            101001
            ^

            101001
              ^

            101001
                 ^


         */
        for (int i = 0; i < binaryString.length(); i++){
            char c = binaryString.charAt(i);

            if(c == '1') {
                if(firstOne == false) {
                    firstOne = true;
                    //secondOne = false;
                    distance = 0;
                } else if(firstOne == true) {
                    //firstOne = false;
                    //secondOne = true;
                    if(distance > maxDistance) {
                        maxDistance = distance;
                    }
                    distance = 0;
                }
            } else if (c == '0') {
                if(firstOne == true) {
                    distance++;
                }
            }
        }

        return maxDistance;
    }

}
