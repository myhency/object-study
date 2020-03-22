package com.james.object.ticketselling;

public class Bag {
    private Long amount;
    private Invitaition invitaition;
    private Ticket ticket;

    public Bag(Long amount) {
        this(null, amount);
    }

    public Bag(Invitaition invitaition, Long amount) {
        this.amount = amount;
        this.invitaition = invitaition;
    }

    public boolean hasInvitation() {
        return invitaition != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
