package org.bova.hackerrank.compete.BlackHistoryMonthCodingContest2021.p4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'shoppingQueries' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER_ARRAY pos
     *  3. LONG_INTEGER_ARRAY amount
     */

    public static List<Integer> shoppingQueries(List<Integer> prices, List<Integer> pos, List<Long> amount) {
        // Write your code here


        prices.add(1);
        prices.add(2);
        prices.add(3);
        prices.add(4);
        prices.add(5);

        /*
            Key - Query
                pos
                amount
            Value
                num

            pos
                amount itemNum
         */

        for(int i = 0; i < prices.size(); i++) {

        }


        pos.add(1);
        pos.add(3);

        amount.add(4L);
        amount.add(14L);

        List<Integer> result = new ArrayList<>();


//        for(int i = 0; i < pos.size(); i++) { // queries
//            for(int k = 0; k < prices.size(); k++) {
//
//            }
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int pricesCount = 0; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> prices = new ArrayList<>();

//        for (int i = 0; i < pricesCount; i++) {
//            int pricesItem = Integer.parseInt(bufferedReader.readLine().trim());
//            prices.add(pricesItem);
//        }

        int posCount = 0; // Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> pos = new ArrayList<>();

//        for (int i = 0; i < posCount; i++) {
//            int posItem = Integer.parseInt(bufferedReader.readLine().trim());
//            pos.add(posItem);
//        }

        int amountCount  = 0; //Integer.parseInt(bufferedReader.readLine().trim());
        List<Long> amount = new ArrayList<>();

//        for (int i = 0; i < amountCount; i++) {
//            long amountItem = Long.parseLong(bufferedReader.readLine().trim());
//            amount.add(amountItem);
//        }

        List<Integer> result = Result.shoppingQueries(prices, pos, amount);

//        for (int i = 0; i < result.size(); i++) {
//            bufferedWriter.write(String.valueOf(result.get(i)));
//
//            if (i != result.size() - 1) {
//                bufferedWriter.write("\n");
//            }
//        }

//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
