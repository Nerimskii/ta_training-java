package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            while (scanner.hasNext()) {
                String[] abc = scanner.nextLine().split("\\s");
                double a = Double.parseDouble(abc[0]);
                double b = Double.parseDouble(abc[1]);
                double c = Double.parseDouble(abc[2]);
                double firstRoot;
                double secondRoot;

                // D = b^2 - 4ac
                // if D < 0 !X
                // if D = 0 only one X
                // if D > 0 X1, X2

                double discriminant = b * b - 4 * a * c;

                if (discriminant < 0) {
                    System.out.println("no roots");

                } else if (discriminant == 0) {
                    firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
                    System.out.println(firstRoot);

                } else {
                    firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
                    secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
                    System.out.println(firstRoot + " " + secondRoot);
                }
            }
        }
    }
}