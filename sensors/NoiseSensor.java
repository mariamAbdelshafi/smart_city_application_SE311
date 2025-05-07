package sensors;

public class NoiseSensor extends Sensor{
    private int noise_level;

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
        if(noise_level > 85){
            //observer notifies citizens noise level is over 85 db
        }
    }
}
