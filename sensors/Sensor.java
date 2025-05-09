package sensors;

public abstract class Sensor {
    protected String location;
    protected boolean malfunctioning = false;

    public Sensor(String location) {
        this.location = location;
    }

    public String getLocation() {
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
}
