package com.epam.rd.autotasks;

public class CarouselRun {
    int[] decrementingCarouselArray;
    int position = 0;
    int actualLength;
    public CarouselRun (int[] decrementingCarouselArray) {
        this.decrementingCarouselArray = decrementingCarouselArray;
        actualLength = decrementingCarouselArray.length;
    }

    public int next() {
        int count = 0;
        while (count < decrementingCarouselArray.length
                && decrementingCarouselArray[position %= decrementingCarouselArray.length] <= 0) {
            position++;
            count++;
        }
        return count == decrementingCarouselArray.length ? -1 : decrementingCarouselArray[position++]--;
    }

    public boolean isFinished() {
        for (int i : decrementingCarouselArray) {
            if (i > 0) return false;
        }
        return true;
    }

}
