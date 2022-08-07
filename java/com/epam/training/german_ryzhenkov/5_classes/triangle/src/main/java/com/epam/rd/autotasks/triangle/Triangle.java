package com.epam.rd.autotasks.triangle;

class Triangle {
    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // if it's not a triangle but a line by 2 different points (a=b or a=c or b=c)
        if (   (a.getX()==b.getX() && a.getY()== b.getY())
            || (b.getX()==c.getX() && b.getY()==c.getY())
            || (a.getX()==c.getX() && a.getY()== c.getY())) {
            throw new IllegalArgumentException();
        }
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
    }

    public double area() {
        //AB² = (y2 - y1)² + (x2 - x1)²
        double abLength = Math.sqrt(Math.pow(b.getY()-a.getY(), 2) + Math.pow(b.getX()-a.getX(), 2));
        double bcLength = Math.sqrt(Math.pow(c.getY()-b.getY(), 2) + Math.pow(c.getX()-b.getX(), 2));
        double caLength = Math.sqrt(Math.pow(a.getY()-c.getY(), 2) + Math.pow(a.getX()-c.getX(), 2));

        //Semiperimetr = (a+b+c)/2
        double semiPerimeter = (abLength+bcLength+caLength)/2;

        //S = Math.sqrt(semiPerimeter*(semiPerimeter-a)*(semiPerimeter-b)*(semiPerimeter-c)
        return Math.sqrt(semiPerimeter * (semiPerimeter - abLength) * (semiPerimeter - bcLength) * (semiPerimeter - caLength));
    }

    public Point centroid(){
        double xOfCentroid = (a.getX()+b.getX()+c.getX())/3;
        double yOfCentroid = (a.getY()+b.getY()+c.getY())/3;
        return new Point(xOfCentroid, yOfCentroid);
    }

}
