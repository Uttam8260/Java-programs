//Observer design pattern says that  when one object change it's state then all its depedants are notified automatically.

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {
// Observer interface
interface Observer {
    void update(float temperature);
}

// Subject (Observable)
static class WeatherStation {
    private float temperature;
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

static class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Phone Display: Temperature updated to " + temperature + "°C");
    }
}

static class LaptopDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Laptop Display: Temperature updated to " + temperature + "°C");
    }
}

// Client

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        PhoneDisplay phoneDisplay = new PhoneDisplay();
        LaptopDisplay laptopDisplay = new LaptopDisplay();

        station.addObserver(phoneDisplay);
        station.addObserver(laptopDisplay);

        station.setTemperature(25.5f);
        station.setTemperature(30.0f);
    }
}
