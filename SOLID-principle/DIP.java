//Dependancy Inversion Principle:-Says that high level modules does not directly depend upon low level modules and vice versa but it is conncted through an abstaction or interface.

public class DIP {

    // Abstraction
    static interface Worker {
        void work();
    }

    // Low-level module 1
    static class Developer implements Worker {
        @Override
        public void work() {
            System.out.println("Developer is writing code.");
        }
    }

    // Low-level module 2
    static class Manager implements Worker {
        @Override
        public void work() {
            System.out.println("Manager is managing the team.");
        }
    }

    // High-level module
    static class CEO {
        private final Worker worker;

        // Depends on abstraction
        public CEO(Worker worker) {
            this.worker = worker;
        }

        public void startWork() {
            System.out.println("CEO assigns the task:");
            worker.work();
        }
    }

    // Main method
    public static void main(String[] args) {
        // CEO works with Developer
        Worker developer = new Developer();
        CEO ceoWithDev = new CEO(developer);
        ceoWithDev.startWork();

        System.out.println("----------------------");

        // CEO works with Manager
        Worker manager = new Manager();
        CEO ceoWithMgr = new CEO(manager);
        ceoWithMgr.startWork();
    }
}
 