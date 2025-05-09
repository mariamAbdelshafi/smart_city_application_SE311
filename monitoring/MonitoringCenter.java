package monitoring;

import commands.Command;
import java.util.ArrayList;
import java.util.List;

public class MonitoringCenter {
    private static MonitoringCenter instance;
    private final List<Command> commandQueue = new ArrayList<>();

    private MonitoringCenter() {}

    public static MonitoringCenter getInstance() {
        if (instance == null) {
            instance = new MonitoringCenter();
        }
        return instance;
    }

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        for (Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}