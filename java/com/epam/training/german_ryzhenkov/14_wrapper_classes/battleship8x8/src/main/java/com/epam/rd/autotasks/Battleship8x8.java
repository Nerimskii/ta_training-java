package com.epam.rd.autotasks;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    private long convertFromBinaryStringToDecimalInt(long shots, int positionOfShot) {
//        System.out.println(new BigInteger(shots) + " - new BigInteger(shots)");
//        System.out.println(new BigInteger(positionOfShot) + " - new BigInteger(positionOfShot)");
//        System.out.println(new BigInteger(shots).add(new BigInteger(positionOfShot)) + " - new BigInteger(shots).add(new BigInteger(positionOfShot))");
//        System.out.println(new BigInteger(new BigDecimal(Math.pow(2, 64-positionOfShot)).toString()).toString(2));
        BigInteger binaryPosition = new BigInteger(new BigInteger(new BigDecimal(Math.pow(2, 63 - positionOfShot)).toString()).toString(2));
        System.out.println(binaryPosition + " - binaryPosition");
        BigInteger oldShots = new BigInteger(new BigInteger(String.valueOf(shots)).abs().toString(2));
        System.out.println(oldShots + " - oldShots");
        BigInteger binaryShots = oldShots.add(binaryPosition);
        System.out.println(binaryShots + " - binaryShots");
        System.out.println(new BigInteger(String.valueOf(binaryShots), 2) + " - new BigInteger(String.valueOf(binaryShots), 2)");
//        System.out.println(new BigInteger(Long.toBinaryString(shots)).add(binaryPosition) + " - new BigInteger(Long.toBinaryString(shots)).add(binaryPosition)");
        return new BigInteger(String.valueOf(binaryShots), 2).longValue();
    }

    private int convertShot(String shot) {
        shot = shot.replace(shot.charAt(0), switch (shot.charAt(0)) {
            case 'A'->'0';
            case 'B'->'1';
            case 'C'->'2';
            case 'D'->'3';
            case 'E'->'4';
            case 'F'->'5';
            case 'G'->'6';
            case 'H'->'7';
            default -> throw new IllegalStateException("Unexpected value: " + shot.charAt(0));
        });

        return Integer.parseInt(String.valueOf(Integer.parseInt(shot)-1), 8);
    }
    public boolean shoot(String shot) {
        int positionOfShot = convertShot(shot);
        shots = convertFromBinaryStringToDecimalInt(shots, positionOfShot);
        System.out.println(shots + " - shots");
        System.out.println(Long.MAX_VALUE + " - MAX of long");


//        StringBuilder stringOfShot = new StringBuilder("");
//        int count = 0;
//        for (int i = 0; i < 64; i++, count++) {
//            if (count == positionOfShot - 1) {
//                stringOfShot.append(1);
//                continue;
//            }
//            stringOfShot.append(0);
//        }

//        shots =
//        for (int i : shotsArray) stringOfShot.append(i);


//        BigInteger binaryShots = convertFromLongToBigInteger(shots);
//        StringBuilder stringBuilderOfShots = new StringBuilder(String.valueOf(binaryShots));
//        char numberOnThisPosition = (char) (stringBuilderOfShots.charAt(positionOfShot-1) + 2);
//
//        stringBuilderOfShots.setCharAt(positionOfShot-1, numberOnThisPosition);
//
//
//
//        shots = new BigInteger(String.valueOf(stringBuilderOfShots)).intValue();
//
//        System.out.println(state());
//        return Integer.parseInt(String.valueOf(stringBuilderOfShots.charAt(positionOfShot))) + 2 == 3;
        return false;
    }

    public String state() {
        String result = "";
        int j = 0;
        System.out.println("in state method");
//        for (int i = 0; i < 8; i++, j+=8) {
//            result = result.concat(String.valueOf(convertFromLongToBigInteger(shots)).substring(j, j + 8).concat("\n"));
//        }
        return result;
    }

}
