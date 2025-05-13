package sensors;

import city.CityComponent;
import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;

//concrete subject
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
        if (temperature < -50 || temperature > 60) {
            malfunctioning = true;
        }
        // notifies citizens temperature <0
        if (temperature < 0) {
            notifyObservers();
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
