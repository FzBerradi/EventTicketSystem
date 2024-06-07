package decorator;

import Models.Ticket;

public class FoodDecorator extends TicketDecorator {

    public FoodDecorator(Ticket decoratedTicket) {
        super(decoratedTicket);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Meal";
    }

    @Override
    public double getPrice() {
        // Assume a meal adds an extra 20 to the price
        return super.getPrice() + 20;
    }
}
