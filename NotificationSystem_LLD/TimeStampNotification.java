package NotificationSystem_LLD;

import java.time.LocalDate;

public class TimeStampNotification extends INotificationDecorator {

    public TimeStampNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getNotification () {
        return "[" + LocalDate.now() + "]" + notification.getNotification();
    }
    
}
