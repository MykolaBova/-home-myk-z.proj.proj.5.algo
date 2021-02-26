package org.bova.hackerrank.compete.BlackHistoryMonthCodingContest2021.p1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
  export OUTPUT_PATH=/home/myk/z.proj.proj.4.algo/getting-started/src/main/java/org/bova/hackerrank/compete/BlackHistoryMonthCodingContest2021/p1/out.txt
          */
class Result1 {

    /*
     * Complete the 'minimumCost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. WEIGHTED_INTEGER_GRAPH tree
     *  2. INTEGER u
     *  3. INTEGER v
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */
    public static int minimumCost(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo, List<Integer> treeWeight, int u, int v) {

        List<Integer> treeVisited = new ArrayList<>();

        for(int i = 0; i < treeNodes; i++) {
            treeVisited.add(0);
        }

        int result = 0;

        treeNodes = 3;

        treeFrom.add(1);
        treeTo.add(2);
        treeWeight.add(10);

        treeFrom.add(2);
        treeTo.add(3);
        treeWeight.add(20);

        u = 1;
        v = 3;

//        for(int i = ) {
//
//        }

        // build tree from arrys

        // traverse tree

        // stop tree traversal wne
        // 0 started from start node
        // 1 all nodes visisted
        // 2 finish node reaced



        System.out.println(result);

        return result;
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String[] treeNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int treeNodes = 0; // = Integer.parseInt(treeNodesEdges[0]);
        int treeEdges; // = Integer.parseInt(treeNodesEdges[1]);

        List<Integer> treeFrom = new ArrayList<>();
        List<Integer> treeTo = new ArrayList<>();
        List<Integer> treeWeight = new ArrayList<>();

//        for (int i = 0; i < treeEdges; i++) {
//            String[] treeFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//            treeFrom.add(Integer.parseInt(treeFromToWeight[0]));
//            treeTo.add(Integer.parseInt(treeFromToWeight[1]));
//            treeWeight.add(Integer.parseInt(treeFromToWeight[2]));
//        }

        int u = 0; //Integer.parseInt(bufferedReader.readLine().trim());

        int v = 0; //Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result1.minimumCost(treeNodes, treeFrom, treeTo, treeWeight, u, v);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
