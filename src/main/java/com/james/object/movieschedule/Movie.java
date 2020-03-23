package com.james.object.movieschedule;

import com.zaxxer.hikari.util.UtilityElf;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy disCountPolicy; //요구사항: 영화별로 하나의 할인 정책만 할당할 수 있다.

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.disCountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(disCountPolicy.calculateDiscountAmount(screening));
    }
}

