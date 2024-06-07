package decorator;

import Models.Event;
import Models.Ticket;
import Models.User;

public abstract class TicketDecorator extends Ticket {
    protected Ticket decoratedTicket;

    public TicketDecorator(Ticket decoratedTicket) {
        super(decoratedTicket.getEvent(), decoratedTicket.getUser(), decoratedTicket.getPrice(), decoratedTicket.getStatus());
        this.decoratedTicket = decoratedTicket;
    }

    @Override
    public String getDescription() {
        return decoratedTicket.getDescription(); // Delegates to the decorated ticket
    }

    @Override
    public double getPrice() {
        return decoratedTicket.getPrice(); // Base decorator does not change the price
    }

}
