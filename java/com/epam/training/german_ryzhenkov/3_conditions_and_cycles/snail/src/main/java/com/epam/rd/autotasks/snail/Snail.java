package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int top = scanner.nextInt();
                int firstH = top;
                int countOfDays = 0;
                while (top > 0) {
                    top -= a;
                    countOfDays++;
                    if (top <= 0) {
                        System.out.println(countOfDays);
                        break;
                    }
                    top += b;
                    if (firstH <= top) {
                        System.out.println("Impossible");
                        break;
                    }
                }
            }
        }
    }
}
