package com.epam.rd.autotasks.segments;

import java.text.DecimalFormat;

class Point {
    private final double x;
    private final double y;

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

    public boolean equalsPoint(Point point) {
        return this.delta(x) == point.delta(point.getX()) && this.delta(y) == point.delta(point.getY());
    }
    public double delta(double i) {
        return Double.parseDouble(new DecimalFormat("#.#").format(i).replace(",", "."));
    }
}
