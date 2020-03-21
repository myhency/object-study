package com.james.object;

public class Bag {
    private Long amount;
    private Invitaition invitaition;
    private Ticket ticket;

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    public Bag(Invitaition invitaition, Long amount) {
        this.amount = amount;
        this.invitaition = invitaition;
    }

    private boolean hasInvitation() {
        return invitaition != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
