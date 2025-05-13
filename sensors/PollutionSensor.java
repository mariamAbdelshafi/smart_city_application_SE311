package sensors;

import city.CityComponent;
import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;

//concrete subject
public class PollutionSensor extends Sensor implements Subject {
    private int pollutionLevel;
    private List<Observer> observers = new ArrayList<>();

    public PollutionSensor(CityComponent location) {
        super(location);
    }

    @Override
    public void display() {
        System.out.println("Pollution sensor");
    }

    @Override
    public void readData() {
        System.out.println("Reading pollution data...");
    }

    @Override
    public void setValue(int value) {
        this.pollutionLevel = value;

        if (pollutionLevel < 0 || pollutionLevel > 500) {
            malfunctioning = true;
        }
        //notifies citizens aqi>100
        if (pollutionLevel > 100) {
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
            observer.update("Pollution level exceeded 100 in " + location + ": " + pollutionLevel);
        }
    }
}
