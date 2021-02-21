package org.bova.hackerrank.interview.arrays.twodarray;

/*
OUTPUT_PATH
/home/myk/z.proj.proj.4.algo/getting-started/src/main/java/org/bova/hackerrank/interview/arrays/twodarray/out.txt
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {


        int currentHourGlass;
        int largestSum = -999;

        for (int i = 1; i < 5; i++){
            for (int j = 1; j < 5; j++){
                currentHourGlass = 0;
                currentHourGlass += arr[i-1][j-1];
                currentHourGlass += arr[i-1][j];
                currentHourGlass += arr[i-1][j+1];
                currentHourGlass += arr[i][j];
                currentHourGlass += arr[i+1][j-1];
                currentHourGlass += arr[i+1][j];
                currentHourGlass += arr[i+1][j+1];
                if (currentHourGlass > largestSum){
                    largestSum = currentHourGlass;
                }

            }
        }

        return largestSum;
    }


    public static int sum(int[][] a,int i,int j)
    {
        int sum;
        sum = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] +a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
