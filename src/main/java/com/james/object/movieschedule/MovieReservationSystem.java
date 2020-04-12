package com.james.object.movieschedule;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class MovieReservationSystem {
    public static void main(String[] args) {
        /**
         * 두 개의 순서 조건과 두 개의 기간 조건을 이용해 할인 여부를 판단
         */
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0), LocalTime.of(11,59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(20,59))));

        /**
         * 금액 할인 정책이 적용된 영화에 비율 할인 정책이 적용되도록 변경하는 것
         */
        avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.1,
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0), LocalTime.of(11,59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(20,59))));

        /**
         * 10%의 비율 할인 정책이 적용되고 두 개의 기간 조건과 한 개의 순서 조건을 이용해 할인 여부를 판단
         */
        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(0.1, //10% 비율의 할인 정책
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14,0), LocalTime.of(16,59)), // 기간 조건
                        new SequenceCondition(2), //한 개의 순서 조건
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(13,59)))); // 기간 조건

        /**
         * ## 부가 정보
         *
         * ### 할인 정책과 할인 조건이 지정된 영화
         *
         * |**스타워즈**<br/>(가격:10,000원)|없음|없음|
         */
        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy());
    }
}
