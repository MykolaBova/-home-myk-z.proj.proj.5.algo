package org.bova.hackerrank.interview.arrays.nychaos;


import java.util.Scanner;

public class Solution {

    // Complete the minimumBribes function below.
    private static void minimumBribes(int[] arr) {
        int swapCount = 0;

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] != i + 1) { // filter cases, when you do not bribe, be at the ith position wherever you are

                if (((i - 1) >= 0) && arr[i - 1] == (i + 1)) { // 1)Being at initial ith position, valid current
                    // position after given bribe can be (i-1)th position
                    swapCount++;
                    swap(arr, i, i - 1);
                } else if (((i - 2) >= 0) && arr[i - 2] == (i + 1)) { // 2)Being at initial ith position, valid current
                    // position after given bribes can be (i-2)th
                    // position
                    swapCount += 2;
                    swap(arr, i - 2, i - 1);
                    swap(arr, i - 1, i);
                } else { // 3)Too chaotic (trying to bribe more than 2 people which is ahead of you)
                    System.out.println("Too chaotic");
                    return;
                }
            }

        }
        System.out.println(swapCount);

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
