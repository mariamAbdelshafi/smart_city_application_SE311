package commands;

import sensors.Sensor;
import commands.Command;

public class ResetCommand implements Command {
    private final Sensor sensor;

    public ResetCommand(Sensor sensor) {
        this.sensor = sensor;
    }

    public void execute() {
        sensor.reset();
    }
}
