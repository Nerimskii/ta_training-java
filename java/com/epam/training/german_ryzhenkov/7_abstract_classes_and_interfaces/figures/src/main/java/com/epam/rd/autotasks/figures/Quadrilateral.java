package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;
    Quadrilateral (Point a, Point b, Point c, Point d) {
        if (a != null && b != null && c != null) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    @Override
    public double area() {
        //|AB|² = (y2 - y1)² + (x2 - x1)²
        double abLength = Math.sqrt(Math.pow(b.getY()-a.getY(), 2) + Math.pow(b.getX()-a.getX(), 2));
        double bcLength = Math.sqrt(Math.pow(c.getY()-b.getY(), 2) + Math.pow(c.getX()-b.getX(), 2));
        //8^2+
        double cdLength = Math.sqrt(Math.pow(d.getY()-c.getY(), 2) + Math.pow(d.getX()-c.getX(), 2));
        double daLength = Math.sqrt(Math.pow(a.getY()-d.getY(), 2) + Math.pow(a.getX()-d.getX(), 2));
        double diagonal = Math.sqrt(Math.pow(a.getY()-c.getY(), 2) + Math.pow(a.getX()-c.getX(), 2));

        //p = (a+b+c)/2
        double p1 = (abLength+bcLength+diagonal)/2;
        double p2 = (daLength + cdLength + diagonal)/2;

        //S = Math.sqrt(p*(p-a)*(p-b)*(p-c)
        double s1 = Math.sqrt(p1 * (p1 - abLength) * (p1 - bcLength) * (p1 - diagonal));
        double s2 = Math.sqrt(p2 * (p2 - daLength) * (p2 - cdLength) * (p2 - diagonal));
        return (s1 + s2);
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX() && a.getX() <= d.getX()) return a;
        if (b.getX() <= a.getX() && b.getX() <= c.getX() && a.getX() <= d.getX()) return b;
        if (c.getX() <= a.getX() && c.getX() <= b.getX() && c.getX() <= d.getX()) return c;
        return d;
    }
}
