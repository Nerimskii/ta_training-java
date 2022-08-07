package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    Point a;
    Point b;
    Point c;

    Triangle (Point a, Point b, Point c) {
        if (a != null && b != null && c != null) {
            this.a = a;
            this.b = b;
            this.c = c;
            if (   a.equalsPoint(b)
                    || b.equalsPoint(c)
                    || c.equalsPoint(a))
                throw new IllegalArgumentException();

            // if it's not a triangle but a line by 3 different points on vert/horiz
            if ((a.getX()==b.getX() && a.getX()==c.getX())
                    || (a.getY()==b.getY() && a.getY()==c.getY())) {
                throw new IllegalArgumentException();
            }

            // if it's not a triangle but a line by 3 different points on diag
            if (a.getX()==a.getY() && b.getX()==b.getY() && c.getX()==c.getY()) {
                throw new IllegalArgumentException();
            }

            // if it's not a triangle but a line by 3 different points on diag
            if (a.getX()/a.getY()==b.getX()/ b.getY() && b.getX()/ b.getY()==c.getX()/c.getY()) {
                throw new IllegalArgumentException();
            }

        } else throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        double xOfCentroid = (a.getX()+b.getX()+c.getX())/3;
        double yOfCentroid = (a.getY()+b.getY()+c.getY())/3;
        return new Point(xOfCentroid, yOfCentroid);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return this.getClass() == figure.getClass()
                && this.area() == ((Triangle) figure).area()
                && this.centroid() == figure.centroid();
    }


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

}
