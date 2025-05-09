package commands;

import sensors.Sensor;
import commands.Command;

public class StatusQueryCommand implements Command {
    private final Sensor sensor;

    public StatusQueryCommand(Sensor sensor) {
        this.sensor = sensor;
    }

    public void execute() {
        System.out.println("Sensor at " + sensor.getLocation() +
                " is malfunctioning: " + sensor.isMalfunctioning());
    }
}
