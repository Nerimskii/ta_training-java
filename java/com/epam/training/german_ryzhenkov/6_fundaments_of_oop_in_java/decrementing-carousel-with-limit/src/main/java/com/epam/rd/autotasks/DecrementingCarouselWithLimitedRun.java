package com.epam.rd.autotasks;

import java.util.Arrays;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    final int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }
    public CarouselRun run(){
        if (isCreated) {
            return null;
        } else {
            isCreated = true;
            decrementingCarouselArray = Arrays.copyOf(decrementingCarouselArray, maxLength);
            return new CarouselRun(decrementingCarouselArray, DecrementingCarouselWithLimitedRun.class.getName(), actionLimit);
        }
    }
}
