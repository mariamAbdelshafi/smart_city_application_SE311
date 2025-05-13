package sensors;

import city.CityComponent;
import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor extends Sensor implements Subject {
    private int temperature;
    private List<Observer> observers = new ArrayList<>();

    public TemperatureSensor(CityComponent location) {
        super(location);
    }

    @Override
    public void display() {
        System.out.println("Temperature sensor");
    }

    @Override
    public void readData() {
        System.out.println("Reading temperature data...");
    }

    @Override
    public void setValue(int value) {
        this.temperature = value;
        //System.out.println("Current temperature at the sensor of " + location + ": " + temperature + "°C");

        if (temperature < -50 || temperature > 60) {
            malfunctioning = true;
        }
        // Notification si la température est inférieure à 0°C
        if (temperature < 0) {
            notifyObservers();  // Notifie les observateurs que la température est inférieure à 0°C
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Temperature is below 0°C in "+ location + ": " + temperature + "°C");
        }
    }
}
