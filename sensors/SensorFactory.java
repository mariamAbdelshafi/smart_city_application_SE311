package sensors;

public class SensorFactory {
    public static Sensor createSensor(String type){
        switch (type.toLowerCase()){
            case "temperature":
                return new TemperatureSensor();
            case "noise":
                return new NoiseSensor();
            case "pollution":
                return new PollutionSensor();
            case "speed":
                return new SpeedSensor();
            default:
                throw new IllegalArgumentException("Unknown sensor type");
        }
    }
}
