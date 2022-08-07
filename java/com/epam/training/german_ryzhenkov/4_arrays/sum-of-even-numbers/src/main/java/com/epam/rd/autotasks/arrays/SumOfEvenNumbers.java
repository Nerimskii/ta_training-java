package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array){
        int sumOfEvenNumbers = 0;
        if (array == null) return sumOfEvenNumbers;
        for (int arrayNumber : array) {
            if (arrayNumber%2 == 0) sumOfEvenNumbers += arrayNumber;
        }
        return sumOfEvenNumbers;
    }
}
