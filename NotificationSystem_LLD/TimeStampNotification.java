package NotificationSystem_LLD;

import java.time.LocalDate;

public class TimeStampNotification extends INotificationDecorator {

    public TimeStampNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getContent () {
        return "[" + LocalDate.now() + "]" + notification.getContent();
    }
    
}
