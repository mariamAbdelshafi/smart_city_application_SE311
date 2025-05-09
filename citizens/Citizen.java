package citizens;

import sensors.Sensor;

public interface Citizen {
    void update(Sensor sensor, String message);
}