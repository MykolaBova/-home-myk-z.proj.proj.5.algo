package org.bova.hackerrank.interview.warmup.countingvalleys;

/*
OUTPUT_PATH
/home/myk/z.proj.proj.4.algo/getting-started/src/main/java/org/bova/hackerrank/interview/warmup/countingvalleys/out.txt
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here

        if(steps <= 0) {
            return 0;
        }

        int numValleys = 0;
        int level = 0;
        int step = 0;

        for (int i = 0; i < path.length(); i++){
            char c = path.charAt(i);
            step = step(c);
            level += step;

            if(level == 0 && step == 1) {
                numValleys++;
            }
        }

        return numValleys;
    }

    private static int step(char c) {
        if(c == 'U')
            return 1;
        else if(c == 'D')
            return -1;
        else
            return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}