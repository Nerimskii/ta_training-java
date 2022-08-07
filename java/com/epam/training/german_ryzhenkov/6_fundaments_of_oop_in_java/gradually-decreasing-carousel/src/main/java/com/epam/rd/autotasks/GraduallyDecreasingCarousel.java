package com.epam.rd.autotasks;

import java.util.Arrays;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public CarouselRun run(){
        if (isCreated) {
            return null;
        } else {
            isCreated = true;
            decrementingCarouselArray = Arrays.copyOf(decrementingCarouselArray, maxLength);
            return new CarouselRun(decrementingCarouselArray, GraduallyDecreasingCarousel.class.getName());
        }
    }
}
