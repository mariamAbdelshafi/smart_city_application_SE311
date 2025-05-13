package monitoring;

import commands.Command;
import commands.StatusQueryCommand;

import java.util.ArrayList;
import java.util.List;

public class MonitoringCenter {
    private static MonitoringCenter instance;
    private final List<Command> commandQueue = new ArrayList<>();
    int malfunctioningCount = 0;

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
        int malfunctioningCount = 0; // ← Tu avais oublié cette ligne

        for (Command command : commandQueue) {
            command.execute();

            if (command instanceof StatusQueryCommand statusCmd) {
                if (statusCmd.isMalfunctioning()) {
                    malfunctioningCount++;
                }
            }
        }

        System.out.println("Total malfunctioning sensors: " + malfunctioningCount);
        commandQueue.clear();
    }

}