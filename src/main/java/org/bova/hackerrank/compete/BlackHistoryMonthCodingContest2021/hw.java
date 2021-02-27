package org.bova.hackerrank.compete.BlackHistoryMonthCodingContest2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *   https://www.hackerrank.com/competitions/black-history-month-coding-contest-2021
 */

public class hw {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] magazine ={};
        String[] note;

        HashMap<String, Integer> mapMagazine = new HashMap<>();
        HashMap<String, Integer> mapNote = new HashMap<>();

        for(String word : magazine) {
            Integer count = mapMagazine.get(word);
            if(count == null) {
                mapMagazine.put(word, 0);
            } else {
                mapMagazine.put(word, count++);
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

        Set<Character> setS2 = new HashSet<>();
        for(Character c : setS2) {

        }

    }

    static String twoStrings(String s1, String s2) {
        Set<Character> setS1 = new HashSet<>();
        Set<Character> setS2 = new HashSet<>();

        for (int i = 0; i < s1.length(); i++){
            setS1.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++){
            setS2.add(s2.charAt(i));
        }

        String result = "NO";
        for(Character c1 : setS1) {
            if(setS2.contains(c1)) {
                result = "YES";
                break;
            }
        }

        return result;
    }
}
