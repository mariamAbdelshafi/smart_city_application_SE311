package sensors;

public class TemperatureSensor extends Sensor{
    private int temperature;
    public TemperatureSensor(String location) {
        super(location);
    }

    @Override
    public void display(){
        System.out.println("Temperature sensor");
    }
    @Override
    public void readData(){
        System.out.println("Reading temperature data...");
    }

    @Override
    public void setValue(int value){
        this.temperature = value;
        if(temperature<0){
            //observer notifies citizen temperature is below 0 degrees
        }
    }
}
