package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int countOfNumbers = 0;
        int sumOfNumbers = 0;
        int actualNumber;
        try (Scanner scannerOfInputNumbers = new Scanner(System.in)) {
            while (scannerOfInputNumbers.hasNextInt()) {
                actualNumber = scannerOfInputNumbers.nextInt();
                if (actualNumber == 0) break;
                sumOfNumbers += actualNumber;
                countOfNumbers++;
            }
        }
        System.out.println(sumOfNumbers/countOfNumbers);
    }

}