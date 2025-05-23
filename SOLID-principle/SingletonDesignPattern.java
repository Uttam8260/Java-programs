// //singleton class is a class that allows only one instance or we can create only one object of that class.
// //We can acgieve this by using constructor name as private.


// public class SingletonDesignPattern{

//     public class DatabaseConnectionManager{

//         private static final DatabaseConnectionManager instance = new DatabaseConnectionManager();

       

//         private DatabaseConnectionManager(){
//             System.out.println("Initializing the database");
//         }

//          public static DatabaseConnectionManager getInstance() {
//             return instance;
//         }

//         public void connect(){
//             System.out.println("Connected to the DB");
//         }
//         public void disConnect(){
//             System.out.println("Disconnected to the DB");
//         }
//     }
//     public static void main(String[] args) {
//         DatabaseConnectionManager db1=DatabaseConnectionManager.getInstance();
//         db1.connect();

//         DatabaseConnectionManager db2=DatabaseConnectionManager.getInstance();
//         db2.disConnect();

//         System.out.println(db1==db2); //true
        
//     }
// }


public class SingletonDesignPattern {

    // Singleton class
    public static class DatabaseConnectionManager {
        // Step 1: Create a static instance
        private static final DatabaseConnectionManager instance = new DatabaseConnectionManager();

        // Step 2: Private constructor to prevent object creation
        private DatabaseConnectionManager() {
            System.out.println("Initializing the database...");
        }

        // Step 3: Public method to return the instance
        public static DatabaseConnectionManager getInstance() {
            return instance;
        }

        public void connect() {
            System.out.println("Connected to the DB");
        }

        public void disconnect() {
            System.out.println("Disconnected from the DB");
        }
    }

    // Main method (Client)
    public static void main(String[] args) {
        DatabaseConnectionManager db1 = DatabaseConnectionManager.getInstance();
        db1.connect();

        DatabaseConnectionManager db2 = DatabaseConnectionManager.getInstance();
        db2.disconnect();

        System.out.println("Both references same? " + (db1 == db2)); // true
    }
}
