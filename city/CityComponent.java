package city;
import sensors.Sensor;

//component
public abstract class CityComponent {
    protected String name;

    public CityComponent(String name){
        this.name = name;
    }
    public abstract void display();
    public abstract void add(CityComponent component);
    public abstract void remove(CityComponent component);
    public void addSensor(Sensor sensor) {}
}
