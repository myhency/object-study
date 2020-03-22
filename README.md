# 영화 예매 시스템

## 요구사항

### 상영(Screening)
- 하나의 영화는 하루 중 다양한 시간대에 걸쳐 한 번 이상 상영될 수 있다.

### 할인(Discount)
- 특정한 조건을 만족하는 예매자는 요금을 할인받을 수 있다.
- 기간조건은 요일, 시작 시간, 종료 시간의 세 부분으로 구성된다.
- 영화 시작 시간이 기간조건안에 포함될 경우 요금을 할인한다.
- 영화별로 하나의 할인 정책만 할당할 수 있다.
- 할인 정책을 지정하지 않는 것도 가능하다.
- 할인 조건은 다수의 할인 조건을 함께 지정할 수 있다.
- 순서 조건과 기간 조건을 섞는 것도 가능하다.
- 할인을 적용하기 위해서는 할인 조건과 할인 정책을 함께 조합해서 사용한다.
- 사용자의 예매 정보가 할인 조건 중 하나라도 만족하는지 검사한다.
- 할인 조건을 만족할 경우 할인 정책을 이용해 할인 요금을 계산하다.
- 할인 정책은 적용돼 있지만 할인 조건을 만족하지 못하는 경우는 요금을 할인하지 않는다.
- 할인 정책이 적용돼 있지 않은 경우에는 요금을 할인하지 않는다.
- 할인 정책은 1인 기준으로 책정된다.

### 예매(Reservation)
- 사용자가 예매를 완료하면 예매 정보를 생성한다.


## 용어사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
|영화|Movie|영화에 대한 기본 정보를 표현. 제목, 상영시간, 가격 정보 등을 가리킨다.|
|상영|Screening|실제 관객들이 영화를 관람하는 사건을 표현. 상영 일자, 시간, 순번 등을 가리킨다.|
|할인 조건|discount condition|가격의 할인 여부를 결정한다.|
|순서 조건|sequence condition|상영 순번을 이용해 할인 여부를 결정하는 규칙.|
|기간 조건|period condition|영화 상영 시작 시간을 이용해 할인 여부를 결정하는 규칙.|
|할인 정책|discount policy|할인 요금을 결정한다.|
|금액 할인 정책|amount discount policy|예매 요금에서 일정 금액을 할인해주는 방식.|
|비율 할인 정책|percent discount policy|정가에서 일정 비율의 요금을 할인해 주는 방식.|
|예매 정보|Reservation|예매가 완료된 사용자에게 제공되는 정보. 제목, 상영정보, 인원, 정가, 결제금액이 포함된다.|

## 모델링

### 상영(Screening)

- `Screening`은 상영할 영화(`movie`), 순번(`sequence`), 상영 시작 시간(`whenScreened`)를 가진다.



# Study

## 객체지향을 위해 집중해야 할 두 가지

- 어떤 클래스가 필요한지를 고민하기 전에 어떤 객체들이 필요한지 고민하라.
- 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야 한다.
  - 객체를 고립된 존재로 바라보지 말고 협력에 참여하는 협력자로 바라보아야 한다.
  - 객체들의 모양과 윤곽이 잡히면 공통된 특성과 상태를 가진 객체들을 타입으로 분류하고 이 타입을 기반으로 클래스를 구현하라.

## 도매인 구조를 따르는 프로그램 구조

![영화 예매 도매인을 구성하는 타입들의 구조](https://github.com/myhency/myImages/blob/master/Object/chapter-02-02-002.png?raw=true)

![도매인 개념의 구조를 따를 클래스 구조](https://github.com/myhency/myImages/blob/master/Object/chapter-02-02-001.png?raw=true)

## 자율적인 객체

- 객체는 상태와 행동을 함께 가지는 복합적인 존재
- 객채는 스스로 판단하고 행동하는 자율적인 존재
- 데이터와 기능을 객체 내부로 함께 묶는 것을 **캡슐화**라고 부른다.
- 접근 제어와 접근 수정자(`public`, `protected`, `private`)
- 퍼블릭 인터페이스와 구현
- 인터페이스와 구현의 분리

## 메시지와 메서드를 구분하자

- 메시지와 메서드의 구분에서 **다형성(polymorphism)** 의 개념이 출발한다.