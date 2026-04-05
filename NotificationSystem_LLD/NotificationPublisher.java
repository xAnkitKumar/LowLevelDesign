package NotificationSystem_LLD;

import java.util.ArrayList;
import java.util.List;

public class NotificationPublisher implements ISubject {

    private final List<IObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(IObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(INotification notification) {
        for (IObserver o : new ArrayList<>(observers)) {
            o.update(notification);
        }
    }

    public void publish(INotification notification) {
        notifyObservers(notification);
    }
}
