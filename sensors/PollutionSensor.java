package sensors;

public class PollutionSensor extends Sensor{
    private int AQI_value;
    public PollutionSensor(String location) {
        super(location);
    }

    @Override
    public void display(){
        System.out.println("Pollution sensor");
    }

    @Override
    public void readData(){
        System.out.println("Reading pollution data...");
    }

    @Override
    public void setValue(int value){
        this.AQI_value = value;
        if(AQI_value > 100){
            //observer notifies the citizens the AQI is above 100
        }
    }

}
