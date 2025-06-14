// Client
public class BridgeDesignPattern {
    // Implementor
    static interface Engine {
        void startEngine();
    }

    // ConcreteImplementors
    static class PetrolEngine implements Engine {
        @Override
        public void startEngine() {
            System.out.println("Starting Petrol Engine...");
        }
    }

    static class DieselEngine implements Engine {
        @Override
        public void startEngine() {
            System.out.println("Starting Diesel Engine...");
        }
    }

    static class ElectricEngine implements Engine {
        @Override
        public void startEngine() {
            System.out.println("Starting Electric Engine silently...");
        }
    }

    // Abstraction
    static abstract class Car {
        protected Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }

        abstract void drive();
    }

    // RefinedAbstractions
    static class Sedan extends Car {
        public Sedan(Engine engine) {
            super(engine);
        }

        @Override
        public void drive() {
            System.out.print("Sedan is driving. ");
            engine.startEngine();
        }
    }

    static class SUV extends Car {
        public SUV(Engine engine) {
            super(engine);
        }

        @Override
        public void drive() {
            System.out.print("SUV is driving. ");
            engine.startEngine();
        }
    }

    public static void main(String[] args) {
        Car sedanWithPetrol = new Sedan(new PetrolEngine());
        Car suvWithDiesel = new SUV(new DieselEngine());
        Car sedanWithElectric = new Sedan(new ElectricEngine());

        sedanWithPetrol.drive();   // Output: Sedan is driving. Starting Petrol Engine...
        suvWithDiesel.drive();     // Output: SUV is driving. Starting Diesel Engine...
        sedanWithElectric.drive(); // Output: Sedan is driving. Starting Electric Engine silently...
    }
}
