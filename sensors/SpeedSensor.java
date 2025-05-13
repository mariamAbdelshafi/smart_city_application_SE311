package sensors;

import city.CityComponent;
import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;

//concrete subject
public class SpeedSensor extends Sensor implements Subject {
    private int speed;
    private List<Observer> observers = new ArrayList<>();

    public SpeedSensor(CityComponent location) {
        super(location);
    }

    @Override
    public void display() {
        System.out.println("Speed sensor");
    }

    @Override
    public void readData() {
        System.out.println("Reading speed data...");
    }

    @Override
    public void setValue(int value) {
        this.speed = value;
        if (speed < 0 || speed > 300) {
            malfunctioning = true;
        }
        //notifies citizens speed<10
        if (speed < 10) {
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
            observer.update("Speed is below 10 km/h in " + location + ": " + speed + " km/h");
        }
    }
}
