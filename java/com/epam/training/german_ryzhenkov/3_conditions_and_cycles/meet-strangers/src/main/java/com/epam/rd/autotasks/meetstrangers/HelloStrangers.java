package com.epam.rd.autotasks.meetstrangers;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int countOfStrangers = Integer.parseInt(scanner.nextLine());
            if (countOfStrangers < 0) {
                System.out.println("Seriously? Why so negative?");
            } else if (countOfStrangers == 0) {
                System.out.println("Oh, it looks like there is no one here");
            } else {
                for (int i = 0; i < countOfStrangers; i++)
                    System.out.println("Hello, " + scanner.nextLine());
            }
        }
    }
}
