package com.epam.rd.autotasks.max;

import java.util.Arrays;

public class MaxMethod {
    public static int max(int[] values) {
        int maxValue = values[0];
        for (int value : values) if (maxValue < value) maxValue = value;
        return maxValue;
    }
}
