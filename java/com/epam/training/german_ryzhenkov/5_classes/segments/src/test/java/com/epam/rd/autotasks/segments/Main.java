package com.epam.rd.autotasks.segments;

public class Main {
    public static void main(String[] args) {

        {
            double length = new Segment(new Point(0, 0), new Point(3, 4)).length();
            System.out.println(length);
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
            Segment second = new Segment(new Point(0, 1), new Point(1, 0));
            Point intersection = first.intersection(second);

            System.out.println(intersection.getX());
            System.out.println(intersection.getY());
        }

//        {
//            Segment first = new Segment(new Point(0, 0), new Point(4, 0));
//            Segment second = new Segment(new Point(2, 1), new Point(1, 2));
//            Point intersection = first.intersection(second);
//
//            System.out.println(intersection == null);
//        }
    }
}
