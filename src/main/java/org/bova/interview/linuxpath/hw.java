package org.bova.interview.linuxpath;

/*


 */
public class hw {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] intArray = {5, 1, 7};

        int index = findPairWithBiggestDifference(intArray);

        System.out.println("index = " + index);
    }

    static int findPairWithBiggestDifference(int[] intArray) {

        /*

            for(int i = 0; i < N - 1; i++) {

            }

            key - index of pair start
            value - difference between elements

            traverse elements of map and find one with bigesrt difference

            int index = -1;
            ind difference = -1;
            for(entries of map) {
                if(differencec < entry.difference) {
                    difference = entry.difference;
                    index = entry.index;
                }
            }

            return index;

            ---
            [diff1, diff2..]

            ---
            Sorted collection

            <difference, index>

         */

        /*

            int index = -1;
            ind difference = -1;

            for(int i = 0; i < N - 1; i++) {
                difference =
                if(differencec < entry.difference) {
                    difference = entry.difference;
                    index = entry.index;
                }
            }

         */

        return 0;
    }
}
