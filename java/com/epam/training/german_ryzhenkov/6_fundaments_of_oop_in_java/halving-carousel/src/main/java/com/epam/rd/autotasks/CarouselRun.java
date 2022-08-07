package com.epam.rd.autotasks;

import java.util.Objects;

public class CarouselRun {

    int[] decrementingCarouselArray;
    int position = 0;
    int actualLength;
    String className;
    public CarouselRun (int[] decrementingCarouselArray, String className) {
        this.decrementingCarouselArray = decrementingCarouselArray;
        this.className = className;
        actualLength = decrementingCarouselArray.length;
    }

    public int next() {
        int count = 0;
        int actual;

        if (count == decrementingCarouselArray.length) return -1;
        if (position == decrementingCarouselArray.length) position = 0;

        if (count < decrementingCarouselArray.length && decrementingCarouselArray[position] == 0) {
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

        } else if (className.equals(HalvingCarousel.class.getName())) {
            decrementingCarouselArray[position] /= 2;
            position++;
            return actual;
        }

        return -1;
    }
    public boolean isFinished() {
        for (int i : decrementingCarouselArray) {
            if (i > 0) return false;
        }
        return true;
    }
}
