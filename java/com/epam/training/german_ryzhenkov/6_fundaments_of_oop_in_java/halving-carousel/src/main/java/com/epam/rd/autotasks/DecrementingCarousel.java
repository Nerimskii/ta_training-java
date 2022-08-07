package com.epam.rd.autotasks;

import java.util.Arrays;

public class DecrementingCarousel {
    int capacity;
    int[] decrementingCarouselArray;
    int maxLength = 0;
    boolean isCreated;
    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        decrementingCarouselArray = new int[capacity];
    }

    public boolean addElement(int element){
        if (element > 0 && maxLength < decrementingCarouselArray.length) {
            decrementingCarouselArray[maxLength] = element;
            maxLength++;
            return true;
        }
        return false;
    }

    public CarouselRun run(){
        if (!isCreated) {
            isCreated = true;
            decrementingCarouselArray = Arrays.copyOf(decrementingCarouselArray, maxLength);
            return new CarouselRun(decrementingCarouselArray, DecrementingCarousel.class.getName());
        } else return null;
    }
}
