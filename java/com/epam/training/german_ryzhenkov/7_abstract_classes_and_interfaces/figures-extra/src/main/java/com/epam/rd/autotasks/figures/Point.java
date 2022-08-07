package com.epam.rd.autotasks.figures;

import java.text.DecimalFormat;

class Point {
    private double x;
    private double y;

    private double delta = 0.05;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public boolean equalsPoint(Point point) {
//        System.out.println(this.toString() + " this point to equal");
//        System.out.println(point.toString() + " Point point to equal");
//        System.out.println((Math.abs(this.x - point.x) == 0 && Math.abs(this.getY() - point.getY()) == 0) + " - Math.abs(this.x - point.x) < delta && Math.abs(this.getY() - point.getY()) < delta");
        return Math.abs(this.x - point.x) <= delta && Math.abs(this.getY() - point.getY()) <= delta;
    }

    public double delta(double i) {
        return Double.parseDouble(new DecimalFormat("#.#").format(i).replace(",", "."));
    }
}
