package org.bova.hackerrank.interview.hashmap.kidnapnote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution0 {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> mapMagazine = new HashMap<>();
        HashMap<String, Integer> mapNote = new HashMap<>();

        for(String word : magazine) {
            Integer count = mapMagazine.get(word);
            if(count == null) {
                mapMagazine.put(word, 1);
            } else {
                mapMagazine.put(word, count++);
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

            Integer mapMagazineCount = mapMagazine.get(setNote.getKey());

            if(setNote.getValue() != mapMagazineCount ) {
                result = "No";
                break;
            }
        }

        System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] magazine = {"two", "times", "three", "is", "not", "four"};

        String[] note = {"two", "times",  "two",  "is",  "four"};

        checkMagazine(magazine, note);
    }
}

