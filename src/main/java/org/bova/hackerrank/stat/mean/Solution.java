package org.bova.hackerrank.stat.mean;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        /*Take input from user*/
        Scanner sc = new Scanner(System.in);

        int n =0;
        n = sc.nextInt();

        int arr[] = new int[n];

        //////////////mean code starts here//////////////////
        int sum = 0;
        for(int i=0;i<n; i++)
        {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println((double)sum/n);

        //////////////mean code ends here//////////////////


        //////////////median code starts here//////////////////
        Arrays.sort(arr);
        int val = arr.length/2;
        System.out.println((arr[val]+arr[val-1])/2.0);
        //////////////median code ends here//////////////////

        //////////////mode code starts here//////////////////
        int maxValue=0;
        int maxCount=0;

        for(int i=0; i<n; ++i)
        {
            int count=0;

            for(int j=0; j<n; ++j)
            {
                if(arr[j] == arr[i])
                {
                    ++count;
                }

                if(count > maxCount)
                {
                    maxCount = count;
                    maxValue = arr[i];
                }
            }
        }
        System.out.println(maxValue);
        //////////////mode code ends here//////////////////

    }
}
