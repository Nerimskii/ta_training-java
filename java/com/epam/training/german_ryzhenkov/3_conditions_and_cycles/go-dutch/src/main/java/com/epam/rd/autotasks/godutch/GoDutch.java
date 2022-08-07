package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        try (Scanner scannerOf = new Scanner(System.in)) {
            while (scannerOf.hasNextInt()) {
                int bill = scannerOf.nextInt();

                if (bill < 0) {
                    System.out.println("Bill total amount cannot be negative");
                    break;
                }

                int countOfFriends = scannerOf.nextInt();

                if (countOfFriends <= 0) {
                    System.out.println("Number of friends cannot be negative or zero");
                    break;
                }
                System.out.println((int) (bill * 1.1 / countOfFriends));
            }
        }
    }
}
