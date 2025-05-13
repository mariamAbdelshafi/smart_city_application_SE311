import city.*;
import observer.Citizens;
import sensors.Sensor;
import sensors.SensorFactory;
import commands.ResetCommand;
import commands.StatusQueryCommand;
import observer.Subject;
import monitoring.MonitoringCenter;
import sensors.SensorHolder;

public class Main {
    public static void main(String[] args) {
        //city structure
        CityComponent city = new City("City");

        CityComponent neighborhood = new Neighborhood("Neighborhood1");

        CityComponent street1 = new Street("Street1");
        CityComponent street2 = new Street("Street2");
        CityComponent street3 = new Street("Street3");

        Appartment appartment1 = new Appartment("Appartment1");
        Appartment appartment2 = new Appartment("Appartment2");
        Appartment appartment3 = new Appartment("Appartment3");

        Pole pole1 = new Pole("Pole1");
        Pole pole2 = new Pole("Pole2");

        city.add(neighborhood);

        neighborhood.add(street1);
        neighborhood.add(street2);
        neighborhood.add(street3);

        street1.add(appartment1);
        street1.add(appartment2);
        street3.add(appartment3);

        street1.add(pole1);
        street2.add(pole2);

        //create sensors
        SensorFactory factory = new SensorFactory();

        CityComponent[] components_appart = { appartment1, appartment2, appartment3 };
        CityComponent[] components_pole = { pole1, pole2 };

        for (CityComponent component : components_appart) {
            component.addSensor(factory.createSensor("temperature", component));
            component.addSensor(factory.createSensor("noise", component));
            component.addSensor(factory.createSensor("pollution", component));
            component.addSensor(factory.createSensor("speed", component));
        }

        for (CityComponent component : components_pole) {
            component.addSensor(factory.createSensor("temperature", component));
            component.addSensor(factory.createSensor("noise", component));
            component.addSensor(factory.createSensor("pollution", component));
            component.addSensor(factory.createSensor("speed", component));
        }

        System.out.println("City structure:\n");
        city.display();

        Sensor tempSensor = ((SensorHolder) appartment1).getSensors().get(0);
        Sensor noiseSensor = ((SensorHolder) pole1).getSensors().get(1);
        Sensor pollutionSensor = ((SensorHolder) pole1).getSensors().get(2);
        Sensor speedSensor = ((SensorHolder) pole1).getSensors().get(3);

        //add an observer(citizens) to the sensors -> the citizen subscribes to the sensors
        Citizens citizen = new Citizens("John");
        ((Subject) tempSensor).registerObserver(citizen);
        ((Subject) noiseSensor).registerObserver(citizen);
        ((Subject) pollutionSensor).registerObserver(citizen);
        ((Subject) speedSensor).registerObserver(citizen);


        tempSensor.setValue(-3);
        noiseSensor.setValue(90);
        pollutionSensor.setValue(60);
        speedSensor.setValue(-5);


        Sensor[] sensors = { tempSensor, noiseSensor, pollutionSensor, speedSensor };
        simulateMonitoring(sensors);
    }

    //simulate periodic monitoring
    public static void simulateMonitoring(Sensor[] sensors) {
        MonitoringCenter center = MonitoringCenter.getInstance();

        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- Monitoring cycle " + (i + 1) + " ---");

            for (Sensor s : sensors) {
                center.addCommand(new StatusQueryCommand(s));
            }

            center.executeCommands();

            for (Sensor s : sensors) {
                if (s.isMalfunctioning()) {
                    new ResetCommand(s).execute();
                }
            }

            try {
                Thread.sleep(5000); //wait 5 seconds between each cycle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
