package com.epam.rd.autotasks;

public class CarouselRun {

    int[] decrementingCarouselArray;
    int position = 0;
    int decrement = 1;
    String className;
    public CarouselRun (int[] decrementingCarouselArray, String className) {
        this.decrementingCarouselArray = decrementingCarouselArray;
        this.className = className;
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
            } else if (className.equals(GraduallyDecreasingCarousel.class.getName())) {
            decrementingCarouselArray[position] -= decrement;
                do {
                    position++;
                    if (position == decrementingCarouselArray.length) {
                        decrement++;
                        position = 0;
                    }
                } while ((decrementingCarouselArray[position] <= 0) && !isFinished());
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
