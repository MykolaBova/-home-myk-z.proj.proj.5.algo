package org.bova.coursera.algo1.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PointSET {

    private TreeSet<Point2D> points;
    public PointSET() {
        points = new TreeSet<>();
    }                               // construct an empty set of points
    public boolean isEmpty() {
        return points.isEmpty();
    }                     // is the set empty?
    public int size() {
        return points.size();
    }                        // number of points in the set
    public void insert(Point2D p) {
        points.add(p);
    }             // add the point to the set (if it is not already in the set)
    public boolean contains(Point2D p) {
        return points.contains(p);
    }           // does the set contain point p?
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);

        for (Point2D p : points)
            StdDraw.point(p.x(), p.y());

        StdDraw.show();
    }                        // draw all points to standard draw
    public Iterable<Point2D> range(RectHV rect) {

        List<Point2D> rangeSet = new ArrayList<>();
        for (Point2D p : points) {
            if (rect.contains(p)) {
                rangeSet.add(p);
            }

        }

        return rangeSet;
    }            // all points that are inside the rectangle (or on the boundary)
    public Point2D nearest(Point2D p) {
        double minDistance = 0;
        Point2D nearPoint = null;
        for (Point2D p2D : points) {
            double distance = p.distanceTo(p2D);
            if (distance > minDistance) {
                nearPoint = p2D;
            }
        }
        return nearPoint;
    }            // a nearest neighbor in the set to point p; null if the set is empty

    public static void main(String[] args) {

    }                 // unit testing of the methods (optional)
}