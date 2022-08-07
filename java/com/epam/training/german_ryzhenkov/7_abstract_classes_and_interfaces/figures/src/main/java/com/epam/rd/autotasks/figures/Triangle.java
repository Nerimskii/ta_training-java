package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    Point a;
    Point b;
    Point c;

    Triangle (Point a, Point b, Point c) {
        if (a != null && b != null && c != null) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


    @Override
    public double area() {
        //|AB|² = (y2 - y1)² + (x2 - x1)²
        double abLength = Math.sqrt(Math.pow(b.getY()-a.getY(), 2) + Math.pow(b.getX()-a.getX(), 2));
        double bcLength = Math.sqrt(Math.pow(c.getY()-b.getY(), 2) + Math.pow(c.getX()-b.getX(), 2));
        double caLength = Math.sqrt(Math.pow(a.getY()-c.getY(), 2) + Math.pow(a.getX()-c.getX(), 2));

        //p = (a+b+c)/2
        double p = (abLength+bcLength+caLength)/2;

        //S = Math.sqrt(p*(p-a)*(p-b)*(p-c)
        return Math.sqrt(p * (p - abLength) * (p - bcLength) * (p - caLength));

    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX()) return a;
        if (b.getX() <= a.getX() && b.getX() <= c.getX()) return b;
        return c;
    }
}
