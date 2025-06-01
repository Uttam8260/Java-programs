// Client
public class CommandDesignPattern {

    // Receiver classes
    static class Light {
        public void turnOn() {
            System.out.println("Light ON");
        }
        public void turnOff() {
            System.out.println("Light OFF");
        }
    }

    static class Fan {
        public void start() {
            System.out.println("Fan STARTED");
        }
        public void stop() {
            System.out.println("Fan STOPPED");
        }
    }

    // Command interface
    interface Command {
        void execute();
    }

    // Concrete Command classes
    static class LightOnCommand implements Command {
        private final Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }
        @Override
        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private final Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    static class FanStartCommand implements Command {
        private final Fan fan;

        public FanStartCommand(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.start();
        }
    }

    static class FanStopCommand implements Command {
        private final Fan fan;

        public FanStopCommand(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.stop();
        }
    }

    // Invoker class
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    // Main method (Client code)
    public static void main(String[] args) {
        // Receivers
        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        // Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanStart = new FanStartCommand(ceilingFan);
        Command fanStop = new FanStopCommand(ceilingFan);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Execute light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Execute fan start
        remote.setCommand(fanStart);
        remote.pressButton();

        // Execute light off
        remote.setCommand(lightOff);
        remote.pressButton();

        // Execute fan stop
        remote.setCommand(fanStop);
        remote.pressButton();
    }
}
