package sensors;
import city.CityComponent;
import observer.Subject;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NoiseSensor extends Sensor implements Subject {
    private int noise_level;
    private List<Observer> observers = new ArrayList<>();
    public NoiseSensor(CityComponent location) {
        super(location);
    }

    @Override
    public void display(){
        System.out.println("Noise sensor");
    }

    @Override
    public void readData(){
        System.out.println("Reading noise data...");
    }

    @Override
    public void setValue(int value){
        this.noise_level = value;
            //observer notifies citizens noise level is over 85 db

        if (noise_level > 200 || noise_level < 0) {
            malfunctioning = true;
        }
        //System.out.println("Current noise level at the sensor of " + location + ": " + noise_level + "db");
            // Notification si la température est inférieure à 0°C
            if (noise_level > 85) {
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
            observer.update("Noise level exceeded 85 db in " + location + ": " + noise_level + " db");
        }
    }
}
