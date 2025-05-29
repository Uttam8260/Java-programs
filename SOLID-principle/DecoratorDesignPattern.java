//user
public class DecoratorDesignPattern {

    // Component Interface
    interface Coffee {
        String getDescription();
        double getCost();
    }

    // Concrete Component
    static class SimpleCoffee implements Coffee {
        @Override
        public String getDescription() {
            return "Simple Coffee";
        }

        @Override
        public double getCost() {
            return 10.0;
        }
    }

    // Decorator Abstract Class
    static abstract class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }
    }

    // Concrete Decorators
    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Milk";
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 1.5;
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Sugar";
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 0.5;
        }
    }

    static class WhipCreamDecorator extends CoffeeDecorator {
        public WhipCreamDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Whip Cream";
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 2.0;
        }
    }
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new WhipCreamDecorator(coffee);

        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());
    }
}
