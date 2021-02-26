package org.bova.hackerrank.compete.BlackHistoryMonthCodingContest2021.p2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



class Result {

    /*
     * Complete the 'calculateMaximumProfit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. INTEGER x
     */

    public static int calculateMaximumProfit(List<Integer> cost, int x) {
        // Write your code here

        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int costCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> cost = new ArrayList<>();

        for (int i = 0; i < costCount; i++) {
            int costItem = Integer.parseInt(bufferedReader.readLine().trim());
            cost.add(costItem);
        }

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.calculateMaximumProfit(cost, x);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
