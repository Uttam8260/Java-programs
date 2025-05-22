//A factory is a  class thst decides which concrete class to instantiate.
//It is used to create objects without exposing the instantiation logic to the client.


interface Notification {
    void notifyUser();
}


class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}

// Factory class
class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type == null || type.isEmpty())
            return null;

        switch (type.toLowerCase()) {
            case "email" -> {
                return new EmailNotification();
            }
            case "sms" -> {
                return new SMSNotification();
            }
            case "push" -> {
                return new PushNotification();
            }
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

// Client
public class FactoryDesignPattern {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.createNotification("email");
        notification1.notifyUser(); // Output: Sending an Email Notification

        Notification notification2 = NotificationFactory.createNotification("sms");
        notification2.notifyUser(); // Output: Sending an SMS Notification

        Notification notification3 = NotificationFactory.createNotification("push");
        notification3.notifyUser(); // Output: Sending a Push Notification
    }
}
