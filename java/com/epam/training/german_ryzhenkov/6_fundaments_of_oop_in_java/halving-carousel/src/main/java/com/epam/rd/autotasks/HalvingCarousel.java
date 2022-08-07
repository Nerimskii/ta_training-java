package com.epam.rd.autotasks;

import java.util.Arrays;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run(){
        if (!isCreated) {
            isCreated = true;
            decrementingCarouselArray = Arrays.copyOf(decrementingCarouselArray, maxLength);
            return new CarouselRun(decrementingCarouselArray, HalvingCarousel.class.getName());
        } else return null;
    }
}
