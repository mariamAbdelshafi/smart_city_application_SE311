package city;

import sensors.Sensor;
import sensors.SensorFactory;
import sensors.SensorHolder;

import java.util.ArrayList;
import java.util.List;

public class Appartment extends CityComponent implements SensorHolder {
    private List<Sensor> sensors;
    public Appartment(String name){
        super(name);
        this.sensors = new ArrayList<>();
    }

    //display the appartment's name and its sensors
    @Override
    public void display(){
        System.out.println("            ->Appartment: " + name);
        for(Sensor s: sensors){
            System.out.println("                Sensor: " + s.getClass().getSimpleName());
        }
    }

    @Override
    public void add(CityComponent component){
        throw new UnsupportedOperationException("An appartment can't contain another component");
    }

    @Override
    public void remove(CityComponent component){
        throw new UnsupportedOperationException("An appartment can't contain another component");
    }

    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }

    //get the sensors of the appart
    @Override
    public List<Sensor> getSensors() {
        return sensors;
    }

    public String getLocation() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
