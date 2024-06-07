package observer;
import java.util.List;

import Models.Event;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Event event);
}
//Observable