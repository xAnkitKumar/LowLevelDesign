package NotificationSystem_LLD;

public class NotificationObserver implements IObserver {

    private final String name;

    public NotificationObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(INotification notification) {
        System.out.println("[" + name + "] Received: " + notification.getContent());
    }
}
