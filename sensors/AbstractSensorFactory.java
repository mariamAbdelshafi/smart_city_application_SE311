package sensors;

import city.CityComponent;

public abstract class AbstractSensorFactory {
    public abstract Sensor createSensor(String type, CityComponent location);
}

