package city;

import sensors.Sensor;
import sensors.SensorFactory;

import java.util.ArrayList;
import java.util.List;

public class Appartment extends CityComponent{
    private List<Sensor> sensors;
    public Appartment(String name){
        super(name);
        this.sensors = new ArrayList<>();
    }

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
}
