package com.james.object.movieschedule;

import org.graalvm.compiler.lir.alloc.lsra.LinearScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을
// TEMPLATE METHOD 패턴[GOF94]이라고 부른다.
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>(); //하나의 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.

    public DiscountPolicy(DiscountCondition ... conditions) { //하나의 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
