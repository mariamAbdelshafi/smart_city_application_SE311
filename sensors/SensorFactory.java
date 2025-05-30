package sensors;

import city.CityComponent;

//create a sensor according to the type
public class SensorFactory extends AbstractSensorFactory{
    public Sensor createSensor(String type, CityComponent location){
        switch (type.toLowerCase()){
            case "temperature":
                return new TemperatureSensor(location);
            case "noise":
                return new NoiseSensor(location);
            case "pollution":
                return new PollutionSensor(location);
            case "speed":
                return new SpeedSensor(location);
            default:
                throw new IllegalArgumentException("Unknown sensor type");
        }
    }
}
