package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;

    double delta = 0.1;
    Quadrilateral (Point a, Point b, Point c, Point d) {
        if (a != null && b != null && c != null && d != null) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;

            if (a.equalsPoint(b)
                    || b.equalsPoint(c)
                    || c.equalsPoint(d)
                    || d.equalsPoint(a)) {
                throw new IllegalArgumentException();
            }

            if (findPointOfIntersect(b, d, a , c) == null
                    || isSegmentHasPoint(a, b, findPointOfIntersect(b, d, a , c))
                    || isSegmentHasPoint(b, c, findPointOfIntersect(b, d, a , c))
                    || isSegmentHasPoint(c, d, findPointOfIntersect(b, d, a , c))
                    || isSegmentHasPoint(d, a, findPointOfIntersect(b, d, a , c))) {
                throw new IllegalArgumentException();
            }
        } else throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {

        Triangle acd = new Triangle(a, c, d);
        Triangle abc = new Triangle(a, b, c);
        Point firstCentroid = acd.centroid();
        Point secondCentroid = abc.centroid();

        Point thirdCentroid = new Triangle(a, b, d).centroid();
        Point fourthCentroid = new Triangle(b, d, c).centroid();

        return findPointOfIntersect(firstCentroid, secondCentroid, thirdCentroid, fourthCentroid);
    }

    @Override
    public boolean isTheSame(Figure figure) {

        return this.getClass() == figure.getClass()
                && this.centroid().equalsPoint(figure.centroid())
                && Math.abs(this.area() - ((Quadrilateral) figure).area()) < delta;

    }

    public boolean isSegmentHasPoint(Point a, Point b, Point point) {

        if (point.equalsPoint(a) || point.equalsPoint(b)) return true;

        double delta = 0.1;

        double lengthOfSegment = findLengthOfSegment(a, b);
        double lengthStartPoint = findLengthOfSegment(a, point);
        double lengthEndPoint = findLengthOfSegment(b, point);

        //if AB is the segment and C is the point: AB = AC + CB
        return Math.abs(lengthOfSegment - lengthStartPoint - lengthEndPoint) < delta;
    }

    public double findLengthOfSegment(Point a, Point b) {
        return Math.sqrt(
                Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    public Point findPointOfIntersect(Point b, Point d, Point a, Point c) {
        double x1 = b.getX();
        double x2 = d.getX();
        double x3 = a.getX();
        double x4 = c.getX();

        double y1 = b.getY();
        double y2 = d.getY();
        double y3 = a.getY();
        double y4 = c.getY();

        double k1;
        double k2;

        double b1;
        double b2;

        double xOfPoint;
        double yOfPoint;
        double helpingNumber;

        if (x1 >= x2) {
            helpingNumber = x1;
            x1 = x2;
            x2 = helpingNumber;

            helpingNumber = y1;
            y1 = y2;
            y2 = helpingNumber;
        }

        if (x3 >= x4) {
            helpingNumber = x3;
            x3 = x4;
            x4 = helpingNumber;

            helpingNumber = y3;
            y3 = y4;
            y4 = helpingNumber;
        }

        if (y1 == y2) {
            k1 = 0;
        } else {
            k1 = (y2 - y1) / (x2 - x1);
        }

        if (y3 == y4) {
            k2 = 0;
        } else {
            k2 = (y4 - y3) / (x4 - x3);
        }

        if (k1 == k2) {
            return null;
        }

        b1 = y1 - k1 * x1;
        b2 = y3 - k2 * x3;


        xOfPoint = (b2 - b1) / (k1 - k2);
        yOfPoint = k1 * xOfPoint + b1;

        Point intersection = new Point(xOfPoint, yOfPoint);

        if (isSegmentHasPoint(a, c, intersection)
                && isSegmentHasPoint(b, d, intersection))
            return new Point(xOfPoint, yOfPoint);

        return null;
    }



    public double area() {

        //|AB|² = (y2 - y1)² + (x2 - x1)²
        double abLength = Math.sqrt(Math.pow(b.getY()-a.getY(), 2) + Math.pow(b.getX()-a.getX(), 2));
        double bcLength = Math.sqrt(Math.pow(c.getY()-b.getY(), 2) + Math.pow(c.getX()-b.getX(), 2));
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
}