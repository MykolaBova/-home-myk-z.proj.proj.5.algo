package org.bova.hackerrank.compete.BlackHistoryMonthCodingContest2021.p3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result2 {

    /*
     * Complete the 'bitCount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static long bitCount(List<Integer> arr, int k) {
        // Write your code here

//        arr.add(3);
//        arr.add(1);
//        arr.add(9);
//        arr.add(8);
//
//        k = 3;

        int num = 0;
        int n = arr.size();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = Integer.bitCount( arr.get(i) | arr.get(j) ) +
                        Integer.bitCount( arr.get(i) & arr.get(j) );

                if(sum >= k) {
                    num++;
//                    System.out.println(arr.get(i) + " " + arr.get(j));
                }
            }
        }

//        System.out.println(num);

        return num;
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = 0; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

//        for (int i = 0; i < arrCount; i++) {
//            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
//            arr.add(arrItem);
//        }

        int k = 0; //Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result2.bitCount(arr, k);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
