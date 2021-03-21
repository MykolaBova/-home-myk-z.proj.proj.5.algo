package org.bova.interview.softhouse;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

var twits = new LinkedList<>();
twits.add("#Java snd #Scale are the Languages ofcognitive and AI developrent. IBM sees cognitive developsent is the future.");
twits.add("Somemore info on the IGM investment in #Scala and Lightbandhttp8/iba-Lightbend-join-forces-enterpri");
twits.add("IBM and @lightbeng sre building an integreted platform for #Jave and #Scale #cognitiveepp development");

public List<String> getHashtags(List<String> twits) { }

list of tags from all tags
uniq
sorted by usage in teets

counter     hashtags
<Integer, Set<String>>

hashtag  counter
<String, Integer>

 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        List twits = new LinkedList<>();
        twits.add("#Java snd #Scale are the Languages ofcognitive and AI developrent. IBM sees cognitive developsent is the future.");
        twits.add("Somemore info on the IGM investment in #Scala and Lightbandhttp8/iba-Lightbend-join-forces-enterpri");
        twits.add("IBM and @lightbeng sre building an integreted platform for #Jave and #Scale #cognitiveepp development");

        solution.getHashtags(twits);
    }

    Map<Integer, Set<String>> counterMap = new HashMap();
    Map<String, Integer> tagsMap = new HashMap<>();

    public List<String> getHashtags(List<String> twits) {
        for(String twit : twits) {
            // parse String
            String[] words = twit.split(" ");

            for(String word : words) {
                if(word.startsWith("#")) {
                    Integer counter = tagsMap.get(word);
                    if(counter == null) {
                        // first entry
                        tagsMap.put(word, 1);
                    } else {
                        tagsMap.put(word, ++counter);
                    }
                }

//                counterMap.get()
//                if() {
//
//                }

            }


            int iii = 0;
        }

        return null;
    }
}
