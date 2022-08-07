package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    private final int degrees;
    private static final Direction[] VALUES = values();

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public static Direction ofDegrees(int degrees) {
        if (degrees == 360) return Direction.N;
        degrees = convertDegreesToReal(degrees);
        for (Direction direction : Direction.values()) {
            if (degrees == direction.getDegrees()) return direction;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = convertDegreesToReal(degrees);
        int differentFirst;
        int differentSecond = 360;
        Direction returningDirection = null;
        for (Direction direction : Direction.values()) {
            if (direction.getDegrees() == degrees) return direction;
            differentFirst = Math.abs(degrees - direction.getDegrees());
            if (differentFirst < differentSecond) {
                differentSecond = differentFirst;
                returningDirection = direction;
            }
        }
        return returningDirection;
    }

    public Direction opposite() {
        return ofDegrees(convertDegreesToReal(this.getDegrees() + 180));
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(direction.ordinal() - this.ordinal()) * 45;
        if (difference > 180) difference = Math.abs(direction.ordinal() - this.ordinal() - 8) * 45;
        return difference;
    }

    public static int convertDegreesToReal(int degrees) {
        if (degrees % 360 >= 0) return degrees % 360;
        return 360 + (degrees % 360);
    }

    public int getDegrees() {
        return degrees;
    }
}
