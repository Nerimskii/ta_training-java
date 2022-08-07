package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    Point center;
    double r;

    Circle(Point center, double r) {
        if (center != null && r != 0) {
            this.center = center;
            this.r = r;
        }
    }

    @Override
    public double area() {
        return Math.PI*r*r;
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - r, center.getY());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + center + r + "]";
    }
}
