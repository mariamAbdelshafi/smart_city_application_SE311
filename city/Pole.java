package city;

import sensors.Sensor;
import sensors.SensorFactory;
import sensors.SensorHolder;

import java.util.ArrayList;
import java.util.List;

public class Pole extends CityComponent implements SensorHolder {
    private List<Sensor> sensors;
    public Pole(String name){
        super(name);
        this.sensors = new ArrayList<>();
    }

    @Override
    public void display(){
        System.out.println("            ->Pole: " + name);
        for(Sensor s: sensors){
            System.out.println("                Sensor: " + s.getClass().getSimpleName());
        }
    }

    @Override
    public void add(CityComponent component){
        throw new UnsupportedOperationException("A pole can't contain another component");
    }

    @Override
    public void remove(CityComponent component){
        throw new UnsupportedOperationException("A pole can't contain another component");
    }

    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }

    @Override
    public List<Sensor> getSensors() {
        return sensors;
    }

    public String getLocation() {
        return name; // Retourne le nom de l'appartement
    }

    @Override
    public String toString() {
        return name; // Affiche le nom de l'appartement pour les alertes
    }
}
