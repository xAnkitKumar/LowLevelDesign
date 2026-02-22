package NotificationSystem_LLD;

public class SignatureNotification extends INotificationDecorator {
    public SignatureNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getNotification() {
        return "Signed Notification:"+notification.getNotification();
    }
}
