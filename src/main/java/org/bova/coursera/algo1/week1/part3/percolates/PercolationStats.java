package org.bova.coursera.algo1.week1.part3.percolates;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;

    private final int trials;

    private final double[] results;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        this.trials = trials;
        results = new double[this.trials];

        for (int i = 0; i < this.trials; i++) {

            int randomCol;
            int randomRow;
            Percolation percolation = new Percolation(n);

            for (;;) {

                randomCol = StdRandom.uniform(1, n + 1);
                randomRow = StdRandom.uniform(1, n + 1);

                if (!percolation.isOpen(randomRow, randomCol)) {
                    percolation.open(randomRow, randomCol);
                }

                if (percolation.percolates()) {

                    results[i] = percolation.numberOfOpenSites() / (0.0 + n * n);
                    break;
                }
            }
        }

    }

    // sample mean of percolation threshold
    public double mean() {

        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {

        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(this.trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(this.trials));
    }

    // test client (see below)
    public static void main(String[] args) {

//        PercolationStats percolationStats = new PercolationStats(4, 10);
//        PercolationStats percolationStats = new PercolationStats(200, 100);
//        PercolationStats percolationStats = new PercolationStats(1, 10);
        PercolationStats percolationStats = new PercolationStats(2, 10);

        StdOut.println("mean                    = " + percolationStats.mean());
        StdOut.println("stddev                  = " + percolationStats.stddev());
        StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() + "," + percolationStats.confidenceHi() + "]");
    }

}
