package sensors;

public abstract class Sensor {
    public abstract void display();
    public abstract void readData();
    public abstract void setValue(int value);
}
