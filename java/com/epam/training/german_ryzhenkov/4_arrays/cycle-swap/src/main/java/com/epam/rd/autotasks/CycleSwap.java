package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length > 0) {
            int firstNumberToSwap = array[array.length - 1];
            int nextNumberToSwap;
            for (int i = 0; i < array.length; i++) {
                nextNumberToSwap = array[i];
                array[i] = firstNumberToSwap;
                firstNumberToSwap = nextNumberToSwap;
            }
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length > 0) {
            int[] copyFirstPartOfArray = Arrays.copyOfRange(array, 0, array.length - shift);
            int[] copySecondPartOfArray = Arrays.copyOfRange(array, array.length - shift, array.length);
            System.arraycopy(copySecondPartOfArray, 0, array, 0, shift);
            System.arraycopy(copyFirstPartOfArray, 0, array, shift, array.length - shift);
        }
    }
}
