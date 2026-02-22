package NotificationSystem_LLD;

public class SimpleNotification implements INotification {

    String text;

    SimpleNotification(String text) 
    {
        this.text = text;
    }

     @Override
     public String getNotification() {
        return text;
     }
}
