package NotificationSystem_LLD;

public abstract class INotificationDecorator implements INotification {

    INotification notification;
    public INotificationDecorator(INotification notification) {
        this.notification = notification;
    }

    public String getNotification()
    {
        return notification.getNotification();
    }

} 
