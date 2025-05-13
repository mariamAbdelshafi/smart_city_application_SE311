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
    public static void main(String[] args){
        //create city structure
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

        //create and add sensors
        SensorFactory factory = new SensorFactory();

        CityComponent[] components_appart = { appartment1, appartment2, appartment3};
        CityComponent[] components_pole = {pole1, pole2 };

        for (CityComponent component : components_appart) {
            component.addSensor(factory.createSensor("temperature", appartment1));
            component.addSensor(factory.createSensor("noise", appartment1));
            component.addSensor(factory.createSensor("pollution", appartment1));
            component.addSensor(factory.createSensor("speed", appartment1));
        }

        for (CityComponent component : components_pole) {
            component.addSensor(factory.createSensor("temperature", pole1));
            component.addSensor(factory.createSensor("noise", pole1));
            component.addSensor(factory.createSensor("pollution", pole1));
            component.addSensor(factory.createSensor("speed", pole1));
        }

        System.out.println("City structure:\n");
        
        city.display();
        // juste après avoir créé les capteurs avec factory :
        Sensor tempSensor = ((SensorHolder) appartment1).getSensors().get(0);
        Sensor noiseSensor = ((SensorHolder) pole1).getSensors().get(1);
        Sensor pollutionSensor = ((SensorHolder) pole1).getSensors().get(2);
        Sensor speedSensor = ((SensorHolder) pole1).getSensors().get(3);

        Citizens citizen = new Citizens("John");
        ((Subject) tempSensor).registerObserver(citizen);
        ((Subject) noiseSensor).registerObserver(citizen);
        ((Subject) pollutionSensor).registerObserver(citizen);
        ((Subject) speedSensor).registerObserver(citizen);

        tempSensor.setValue(-3);
        noiseSensor.setValue(90);
        pollutionSensor.setValue(60);
        speedSensor.setValue(-5);



        MonitoringCenter center = MonitoringCenter.getInstance();
        center.addCommand(new StatusQueryCommand(tempSensor));
        center.addCommand(new StatusQueryCommand(noiseSensor));
        center.addCommand(new StatusQueryCommand(pollutionSensor));
        center.addCommand(new StatusQueryCommand(speedSensor));
        center.executeCommands();



    }
}
