package sensors;

import java.util.List;

public interface SensorHolder {
    void addSensor(Sensor sensor);
    List<Sensor> getSensors();
}
