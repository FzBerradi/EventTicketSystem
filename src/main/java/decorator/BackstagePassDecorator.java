package decorator;

import Models.Ticket;

public class BackstagePassDecorator extends TicketDecorator {

    public BackstagePassDecorator(Ticket decoratedTicket) {
        super(decoratedTicket);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Backstage Pass";
    }

    @Override
    public double getPrice() {
        // Assume backstage pass adds an extra 100 to the price
        return super.getPrice() + 100;
    }
}
