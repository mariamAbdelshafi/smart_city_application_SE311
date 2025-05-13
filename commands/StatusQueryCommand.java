package commands;

import sensors.Sensor;

//concrete command

public class StatusQueryCommand implements Command {
    private final Sensor sensor;
    private boolean malfunctioning = false;

    public StatusQueryCommand(Sensor sensor) {
        this.sensor = sensor;
    }

    //averts if a sensors is malfunctionning
    @Override
    public void execute() {
        if (sensor.isMalfunctioning()) {
            malfunctioning = true;
            String sensorType = sensor.getClass().getSimpleName();
            System.out.println(sensorType + " at " + sensor.getLocation() + " is malfunctioning");
        }
    }

    public boolean isMalfunctioning() {
        return malfunctioning;
    }
}
