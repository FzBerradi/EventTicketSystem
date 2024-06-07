package decorator;

import Models.Ticket;

public class VIPDecorator extends TicketDecorator {
    private final double vipPriceIncrease = 50.0; // VIP price increase

    public VIPDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + VIP Access"; // Enhance description
    }

    @Override
    public double getPrice() {
        return super.getPrice() + vipPriceIncrease; // Increase price for VIP
    }
}
