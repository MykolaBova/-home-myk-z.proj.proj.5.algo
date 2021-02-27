package org.bova.hackerrank.interview.hashmap.kidnapnote;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> mapMagazine = new HashMap<>();
        HashMap<String, Integer> mapNote = new HashMap<>();

        for(String word : magazine) {
            Integer count = mapMagazine.get(word);
            if(count == null) {
                mapMagazine.put(word, 1);
            } else {
                mapMagazine.put(word, ++count);
            }
        }

        for(String word : note) {
            Integer count = mapNote.get(word);
            if(count == null) {
                mapNote.put(word, 1);
            } else {
                mapNote.put(word, ++count);
            }
        }

        String result = "Yes";
        for(Map.Entry<String,Integer> setNote : mapNote.entrySet()) {

            if(setNote.getValue() > mapMagazine.get(setNote.getKey())) {
                result = "No";
                break;
            }
        }

        System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
