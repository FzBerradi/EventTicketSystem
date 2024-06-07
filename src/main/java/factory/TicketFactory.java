package factory;

import Models.Event;
import Models.Ticket;
import Models.User;
import decorator.BackstagePassDecorator;
import decorator.FoodDecorator;
import decorator.VIPDecorator;

public class TicketFactory {

    public static Ticket createBasicTicket(Event event, User user) {
        return new Ticket(event,user, event.getBasePrice(), "Basic Event Ticket");
    }

    public static Ticket createVIPTicket(Event event, User user) {
        Ticket basicTicket = createBasicTicket(event, user);
        System.out.println("basicTicket service toString  "+basicTicket.toString());
        return new VIPDecorator(basicTicket);
    }

    public static Ticket createMealTicket(Event event, User user) {
        Ticket basicTicket = createBasicTicket(event, user);
        return new FoodDecorator(basicTicket);
    }

    public static Ticket createFullPackageTicket(Event event, User user) {
        Ticket basicTicket = createBasicTicket(event, user);
        Ticket vipTicket = new VIPDecorator(basicTicket);
        Ticket foodTicket = new FoodDecorator(vipTicket);
        return new BackstagePassDecorator(foodTicket);
    }

    public static Ticket createTicket(String type, Event event, User user) {
        switch (type) {
            case "VIP":
                return createVIPTicket(event, user);
            case "Food":
                return createMealTicket(event, user);
            case "FullPackage":
                return createFullPackageTicket(event, user);
            case "Basic":
            default:
                return createBasicTicket(event, user);
        }
    }

}
