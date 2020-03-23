package com.james.object.movieschedule;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
