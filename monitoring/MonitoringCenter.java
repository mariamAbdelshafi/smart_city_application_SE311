package monitoring;

import commands.Command;
import commands.StatusQueryCommand;

import java.util.ArrayList;
import java.util.List;

public class MonitoringCenter {
    //unique instance
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

    //execute all the commands
    public void executeCommands() {
        int malfunctioningCount = 0; // ← Tu avais oublié cette ligne

        for (Command command : commandQueue) {
            command.execute();

            //check if a sensor is malfunctioning
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