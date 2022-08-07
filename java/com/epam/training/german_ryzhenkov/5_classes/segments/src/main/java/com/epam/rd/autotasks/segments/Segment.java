package com.epam.rd.autotasks.segments;

class Segment {
    final Point start;
    final Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;

        if (this.start.getX() == this.end.getX() && this.start.getY() == this.end.getY()) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        return Math.sqrt(Math.pow((end.getY() - start.getY()), 2)
                + Math.pow((end.getX() - start.getX()), 2));
    }

    Point middle() {
        double xOfPoint = (start.getX() + end.getX()) / 2;
        double yOfPoint = (start.getY() + end.getY()) / 2;
        return new Point(xOfPoint, yOfPoint);
    }

    Point intersection(Segment another) {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double x3 = another.start.getX();
        double x4 = another.end.getX();

        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double y3 = another.start.getY();
        double y4 = another.end.getY();


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

        if (isSegmentHasPoint(this.start, this.end, intersection)
                && isSegmentHasPoint(another.start, another.end, intersection))
            return new Point((b2 - b1) / (k1 - k2), k1 * ((b2 - b1) / (k1 - k2)) + b1);
        return null;
    }

    public boolean isSegmentHasPoint(Point start, Point end, Point point) {
        if (point.equalsPoint(start) || point.equalsPoint(end)) return true;
        double delta = 0.1;

        double lengthOfSegment = new Segment(start, end).length();
        double lengthStartPoint = new Segment(start, point).length();
        double lengthEndPoint = new Segment(end, point).length();

        //if AB is the segment and C is the point: AB = AC + CB
        return Math.abs(lengthOfSegment - lengthStartPoint - lengthEndPoint) < delta;
    }
}
