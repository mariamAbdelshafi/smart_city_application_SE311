package sensors;

public class SpeedSensor extends Sensor{
    private int speed;

    @Override
    public void display(){
        System.out.println("Speed sensor");
    }

    @Override
    public void readData(){
        System.out.println("Reading speed data...");
    }

    @Override
    public void setValue(int value){
        this.speed = value;
        if(speed<10){
            //observer notifies citizens the speed is below 10 km/hr
        }
    }
}
