package com.epam.rd.autotasks.figures;

import java.text.DecimalFormat;

class Circle extends Figure {
    Point center;
    double r;
    double delta = 0.05;
    Circle(Point center, double r) {
        if (center != null && r > 0) {
            this.center = center;
            this.r = Double.parseDouble(new DecimalFormat("#.#").format(r).replace(",", "."));;
        } else throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return this.getClass() == figure.getClass()
                && this.center.equalsPoint(((Circle) figure).center)
                && this.equalsR((Circle) figure);
    }

    public boolean equalsR(Circle circle) {
        return Math.abs(this.r - circle.r) < delta;
    }
}
