// Strategy for movement
interface MovementStrategy {
    void move();
}

class WalkMovement implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Robot is walking.");
    }
}

class FlyMovement implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Robot is flying.");
    }
}

class RollMovement implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Robot is rolling.");
    }
}

// Strategy for task
interface TaskStrategy {
    void performTask();
}

class WeldingTask implements TaskStrategy {
    @Override
    public void performTask() {
        System.out.println("Robot is welding.");
    }
}

class PaintingTask implements TaskStrategy {
    @Override
    public void performTask() {
        System.out.println("Robot is painting.");
    }
}

class CleaningTask implements TaskStrategy {
    @Override
    public void performTask() {
        System.out.println("Robot is cleaning.");
    }
}

// Robot class using Strategy pattern
class Robot {
    private MovementStrategy movementStrategy;
    private TaskStrategy taskStrategy;

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void setTaskStrategy(TaskStrategy taskStrategy) {
        this.taskStrategy = taskStrategy;
    }

    public void move() {
        if (movementStrategy != null)
            movementStrategy.move();
        else
            System.out.println("No movement strategy set.");
    }

    public void performTask() {
        if (taskStrategy != null)
            taskStrategy.performTask();
        else
            System.out.println("No task strategy set.");
    }
}

// Client
public class RobotStrategyDemo {
    public static void main(String[] args) {
        Robot robot = new Robot();

        // Assign walking and welding
        robot.setMovementStrategy(new WalkMovement());
        robot.setTaskStrategy(new WeldingTask());
        robot.move();         // Robot is walking.
        robot.performTask();  // Robot is welding.

        // Change behavior to flying and painting
        robot.setMovementStrategy(new FlyMovement());
        robot.setTaskStrategy(new PaintingTask());
        robot.move();         // Robot is flying.
        robot.performTask();  // Robot is painting.

        // Change to rolling and cleaning
        robot.setMovementStrategy(new RollMovement());
        robot.setTaskStrategy(new CleaningTask());
        robot.move();         // Robot is rolling.
        robot.performTask();  // Robot is cleaning.
    }
}
