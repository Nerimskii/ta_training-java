package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int[] arrayWithRemovedLocalMaximas = new int[array.length];
        int indexOfReturnableArray = 0;

        for (int i = 0; i < array.length; i++) {
            if ((i > 0 && array[i] <= array[i - 1]) ||
                    (i != array.length - 1 && array[i] <= array[i + 1])) {
                arrayWithRemovedLocalMaximas[indexOfReturnableArray++] = array[i];
            }
        }
        return Arrays.copyOf(arrayWithRemovedLocalMaximas, indexOfReturnableArray);
    }
}
