package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {

    int[] decrementingCarouselArray;
    int position = 0;
    boolean isActionLimit;
    int actionLimit = 0;
    String className;
    public CarouselRun (int[] decrementingCarouselArray, String className) {
        this.decrementingCarouselArray = decrementingCarouselArray;
        this.className = className;
    }

    public CarouselRun (int[] decrementingCarouselArray, String className, int actionLimit) {
        this.decrementingCarouselArray = decrementingCarouselArray;
        this.className = className;
        this.actionLimit = actionLimit;
        isActionLimit = true;
    }

    public int next() {
        int count = 0;
        int actual;

        if (isFinished()) return -1;
        if (position == decrementingCarouselArray.length) position = 0;

        if (decrementingCarouselArray[position] == 0) {
            while (decrementingCarouselArray[position] == 0) {
                if (count == decrementingCarouselArray.length) return -1;
                position++;
                count++;
                if (position >= decrementingCarouselArray.length) position = 0;
            }
        }

        actual = decrementingCarouselArray[position];

        if (className.equals(DecrementingCarousel.class.getName())) {
            decrementingCarouselArray[position]--;
            position++;
            return actual;
        }
        else if (className.equals(DecrementingCarouselWithLimitedRun.class.getName())) {
            if (actionLimit == 1) {
                Arrays.fill(decrementingCarouselArray, 0);
            }
            decrementingCarouselArray[position]--;
            position++;
            actionLimit--;
            return actual;
        }
        return -1;
    }
    public boolean isFinished() {
        for (int i : decrementingCarouselArray)
            if (i > 0) return false;
        return true;
    }
}
