package sensors;
import city.CityComponent;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor implements Subject {
    protected CityComponent location;
    protected boolean malfunctioning = false;
    private List<Observer> observers = new ArrayList<>();

    public Sensor(CityComponent location) {
        this.location = location;
    }

    public CityComponent getLocation() {
        return location;
    }

    public boolean isMalfunctioning() {
        return malfunctioning;
    }

    public void reset() {
        this.malfunctioning = false;
        System.out.println(this.getClass().getSimpleName() + " at " + location + " has been reset.");
    }
    public abstract void display();
    public abstract void readData();
    public abstract void setValue(int value);

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update("ALERT from " + getLocation() + ": " + message);
        }
    }
}
