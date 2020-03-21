# 티켓 판매 애플리케이션

## 요구사항

- 이벤트에 당첨된 관람객과 그렇지 못한 관람객은 다른 방식으로 입장시켜야 한다.
- 이벤트에 당첨된 관람객은 초대장을 티켓으로 교환한 후에 입장할 수 있다.
- 이벤트에 당첨되지 않은 관람객은 티켓을 구매해야만 입장할 수 있다.
- 관람객을 입장시키기 전에 이벤트 당첨 여부를 확인해야 한다.
- 이벤트 당첨자에게는 초대장이 발송된다.
- 관람객은 소극장에 올 때 가방을 가져온다.
- 가방안에는 초대장과 티켓이 동시에 보관될 수 없다. 
- 매표소에는 관람객에게 판매할 티켓과 티켓의 판매 금액이 보관돼 있어야 한다.
- 판매원은 매표소에서 초대장을 티켓으로 교환해 주거나 티켓을 판매하는 역할을 수행한다.

## 용어사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
|가방|Bag|관람객이 소극장에 올 때 가지고 온다. 가방에는 초대장, 현금, 티켓이 담긴다.|
|초대장|Invitation|이벤트에 당첨된 관람객에게 지급되는 것. 초대장은 티켓으로 교환할 수 있다.|
|현금|Amount|초대장을 구매하기 위해 제출하는 돈.|
|티켓|Ticket|소극장에 입장하기 위해 제출하는 것.|
|매표소|TicketOffice|관람객에게 티켓을 판매하고 초대장을 티켓으로 교환해 주는 곳.|
|판매원|TicketSeller|매표소에서 초대장을 티켓으로 교환해 주거나 티켓을 판매하는 역할을 수행하는 사람.|
|소극장|Theater|관람객이 공연을 보는 곳.|

# Study

## 소프트웨어 모듈이 가져야 하는 세 가지 기능

로버트 마틴(Robert C. Martin)은 `클린 소프트웨어: 애자일 원칙과 패턴, 그리고 실천 방법` 에서 
소프트웨어 모듈이 가져야 하는 세 가지 기능에 관해 설명한다.

- 모듈은 제대로 실행돼야 한다.
- 변경이 용이해야 한다.
- 이해하기 쉬워야 한다.

Chapter 01-01 에서 작성한 프로그램은 변경 용이성과 읽는 사람과의 의사소통이 어렵다.

## 문제점

```java
public void enter(Audience audience) {
    if (audience.getBag().hasInvitation()) {
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        audience.getBag().setTicket(ticket);
    } else {
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        audience.getBag().minusAmount(ticket.getFee());
        ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
        audience.getBag().setTicket(ticket);
    }
}

```

### 관람객과 판매원이 소극장의 통제를 받는 수동적인 존재라는 점

Theater 클래스의 enter 메서드는 관람객의 가방을 직접적으로 열고 뭔가를 담고 옮기는 행위를 한다.
관람객의 가방을 소극장에서 뒤질 권한이 있다는 것은 말이 되지 않는다. 판매원인 경우에도 마찬가지로 
관람객에게 돈을 받고 티켓을 판매하는 행위를 판매원이 직접 하지 않고 소극장이 한다.

### 코드를 이해하기 위해서 여러 가지 세부적인 내용들을 한꺼번에 기억해야 함

하나의 클래스나 메서드에서 너무 많은 세부사항을 다루기 때문에 코드 가독성이 떨어진다.

`audience.getBag()` : 관람객이 가방을 가지고 있다는 사실을 알아야 한다.
`ticketSeller.getTicketOffice().getTicket()` : `TicketSeller`가 `TicketOffice`에서 티켓을 판매하고, 
`TicketOffice`안에 돈과 티켓이 보관돼 있다는 사실을 알아야 한다.

### 변경에 취약함

`Audience`클래스의 내용이 바뀌면 `Audience`의 `Bag`에 직접 접근하는 `Theater`의 `enter`메서드도
수정해야 한다. 

다른 클래스가 `Audience`의 내부에 대해 더 많이 알면 알수록 `Audience`를 변경하기 어려워진다.

**의존성(dependency)** 은 어플리케이션의 기능을 구현하는 데 필요한 최소한만 유지하고 
불필요한 것을 제거해야 한다. 이렇게 되면 **결합도(coupling)** 가 낮아진다.