package sensors;

import java.util.List;

//sensor organisation
public interface SensorHolder {
    void addSensor(Sensor sensor);
    List<Sensor> getSensors();
}
