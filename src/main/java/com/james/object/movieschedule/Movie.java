package com.james.object.movieschedule;

import com.zaxxer.hikari.util.UtilityElf;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DisCountPolicy disCountPolicy;

    public Movie(String title, Duration renningTime, Money fee, DiscountPlolicy discountPlolicy) {
        thie.title = title;
        thie.renngingTime = renningTime;
        this.fee = fee;
        this.disCountPolicy = discountPlolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money caclulateMonieFee(Screening screening) {
        return fee.minus(disCountPolicy.calculateDiscountAmount(screening));
    }
}

