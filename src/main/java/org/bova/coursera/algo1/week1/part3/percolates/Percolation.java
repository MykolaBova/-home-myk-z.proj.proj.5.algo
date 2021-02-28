package org.bova.coursera.algo1.week1.part3.percolates;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final  boolean OPEN = true;
    private static final  boolean BLOCKED = false;

    private int numOfOpenSites = 0;

//    private static boolean[][] site;
    private boolean[][] site;
    private final int n;

    private final int topIndex;
    private final int bottomIndex;

    private final WeightedQuickUnionUF weightedQuickUnionUF;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        site = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                site[i][j] = BLOCKED;
            }
        }

        this.n = n;

        topIndex = 0;
        bottomIndex = n*n + 2 - 1;

        weightedQuickUnionUF = new WeightedQuickUnionUF(n*n + 2);
    }

    /**
     *      TOP siteRaw[1] ....siteRaw[n*n] BOTTOM
     */
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {

        if (row <= 0 || row > n) {
            throw new IllegalArgumentException();
        }
        if (col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }

        int internalRow = row - 1;
        int internalCol = col - 1;
        int rawIndex = (row - 1) * this.n + col;

        if (!isOpen(row, col)) {
            site[internalRow][internalCol] = OPEN;
            numOfOpenSites++;
        } else {
            return; // Already opened before site
        }

        if (internalRow == 0 && isOpen(row, col)) {
            weightedQuickUnionUF.union(topIndex, rawIndex);
        } else if (internalRow == n - 1 && isOpen(row, col)) {
            weightedQuickUnionUF.union(bottomIndex, rawIndex);
        }

        if (col > 1 && isOpen(row, col - 1)) { // LEFT
            weightedQuickUnionUF.union(rawIndex, rawIndex - 1);
        }
        if (col < n && isOpen(row, col + 1)) { // RIGHT
            weightedQuickUnionUF.union(rawIndex, rawIndex + 1);
        }
        if (row > 1 && isOpen(row - 1, col)) { // TOP
            weightedQuickUnionUF.union(rawIndex, rawIndex - n);
        }
        if (row < n && isOpen(row + 1, col)) { // BOTTOM
            weightedQuickUnionUF.union(rawIndex, rawIndex + n);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > n) {
            throw new IllegalArgumentException();
        }
        if (col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }

        return site[row - 1][col - 1] == OPEN;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || row > n) {
            throw new IllegalArgumentException();
        }
        if (col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }

        int currentSetElement = weightedQuickUnionUF.find((row - 1) * this.n + col);
        int topSetElement = weightedQuickUnionUF.find(this.topIndex);

        return currentSetElement == topSetElement;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {

        return numOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {

//        int rawRow = this.n;
//
//        for (int col = 1; col <= n; col++ ) {
//
//            if (isFull(rawRow, col)) {
//                return true;
//            }
//        }

        if(n == 1) {
            return true;
        }

        int topSetElement = weightedQuickUnionUF.find(this.topIndex);
        int bottomSetElement = weightedQuickUnionUF.find(this.bottomIndex);

        return topSetElement == bottomSetElement;
    }

    // test client (optional)
    public static void main(String[] args) {

        int n = 4;
        Percolation percolation = new Percolation(n);

//        percolation.open(1,1);
//        assert(!percolation.percolates());
//        percolation.open(2,1);
//        assert(!percolation.percolates());
//        percolation.open(3,1);
//        assert(!percolation.percolates());
//        percolation.open(4,1);
//        assert(percolation.percolates());


        int randomCol;
        int randomRow;

        for (;;) {

//            for(int i = 0; i < n; i++) {
//                for(int j = 0; j < n; j++) {
//                    StdOut.print(site[i][j] + " ");
//                }
//                StdOut.println("");
//            }
            StdOut.println("--------------------------------------------------------");

            randomCol = StdRandom.uniform(1, n + 1);
            randomRow = StdRandom.uniform(1, n + 1);

            StdOut.println("randomCol = " + randomCol);
            StdOut.println("randomRow = " + randomRow);
            StdOut.println("rawIndeex = " + ((randomRow - 1) * n + randomCol) );

            if (!percolation.isOpen(randomRow, randomCol)) {
                percolation.open(randomRow, randomCol);
                StdOut.println("OPENING cell");
            } else {
                StdOut.println("cell already OPEN = " + randomRow);
            }

            if (percolation.percolates()) {
                StdOut.println("n = " + n);
                StdOut.println("numberOfOpenSites = " + percolation.numberOfOpenSites());
                return;
            }
        }
    }
}
