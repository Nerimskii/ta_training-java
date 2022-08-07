package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int numberOfPizzas = 1;
                int countOfPeople = scanner.nextInt();
                int countOfPiecesPerPizza = scanner.nextInt();
                int onePizzaOneMan = countOfPiecesPerPizza;
                while (countOfPiecesPerPizza % countOfPeople != 0) {
                    countOfPiecesPerPizza += onePizzaOneMan;
                    numberOfPizzas++;
                }
                System.out.println(numberOfPizzas);
            }
        }
    }
}
