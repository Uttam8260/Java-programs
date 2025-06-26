import java.util.*;

public class TinderDesign {

    // User profile
    static class User {
        private final String name;
        @SuppressWarnings("unused")
        private final int age;
        @SuppressWarnings("unused")
        private final String gender;
        private final String location;
        private final List<String> interests;
        @SuppressWarnings("unused")
        private final List<String> hobbies;
        private final List<User> matches = new ArrayList<>();
        private final List<NotificationObserver> observers = new ArrayList<>();

        public User(String name, int age, String gender, String location, List<String> interests, List<String> hobbies) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.location = location;
            this.interests = interests;
            this.hobbies = hobbies;
        }

        public void matchWith(User otherUser) {
            if (isMatch(otherUser)) {
                matches.add(otherUser);
                notifyObservers("You matched with " + otherUser.name);
                otherUser.notifyObservers("You matched with " + name);
            }
        }

        private boolean isMatch(User other) {
            return this.location.equals(other.location) &&
                   !Collections.disjoint(this.interests, other.interests);
        }

        public void addObserver(NotificationObserver observer) {
            observers.add(observer);
        }

        private void notifyObservers(String msg) {
            for (NotificationObserver observer : observers) {
                observer.notify(msg);
            }
        }

        public String getName() {
            return name;
        }

        public List<User> getMatches() {
            return matches;
        }
    }

    // Observer Interface
    interface NotificationObserver {
        void notify(String msg);
    }

    // Concrete observer
    static class UserNotifier implements NotificationObserver {
        private final String username;
        public UserNotifier(String username) {
            this.username = username;
        }

        @Override
        public void notify(String msg) {
            System.out.println("Notification for " + username + ": " + msg);
        }
    }

    // Chat system
    static class Chat {
        private final List<User> participants = new ArrayList<>();

        public Chat(User... users) {
            participants.addAll(Arrays.asList(users));
        }

        public void sendMessage(User sender, String msg) {
            for (User user : participants) {
                if (!user.getName().equals(sender.getName())) {
                    System.out.println("Msg  " + sender.getName() + " to " + user.getName() + ": " + msg);
                }
            }
        }
    }
    public static void main(String[] args) {
        User john = new User("John", 25, "Male", "Bangalore", 
                             Arrays.asList("Hiking", "Movies", "Music"), 
                             Arrays.asList("Reading", "Gaming"));

        User jane = new User("Jane", 24, "Female", "Bangalore", 
                             Arrays.asList("Movies", "Cooking", "Music"), 
                             Arrays.asList("Painting", "Gaming"));

        User bob = new User("Bob", 26, "Male", "Mumbai", 
                            Arrays.asList("Cricket", "Movies"), 
                            Arrays.asList("Dancing"));

        // Add notification observers
        john.addObserver(new UserNotifier(john.getName()));
        jane.addObserver(new UserNotifier(jane.getName()));
        bob.addObserver(new UserNotifier(bob.getName()));

        // Matching
        john.matchWith(jane); //same location + shared interest
        jane.matchWith(bob);  //different location

        // Chat between matched users
        System.out.println("\n--- 1-on-1 Chat ---");
        Chat oneOnOne = new Chat(john, jane);
        oneOnOne.sendMessage(john, "Hey Jane, nice to meet you!");
        oneOnOne.sendMessage(jane, "Hi John, same here!");

        // Group chat with Bob
        System.out.println("\n--- Group Chat ---");
        Chat groupChat = new Chat(john, jane, bob);
        groupChat.sendMessage(bob, "Hey folks, what's up?");
        groupChat.sendMessage(jane, "Hey Bob, all good!");

    }
}
