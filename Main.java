    import city.*;
    import sensors.Sensor;
    import sensors.SensorFactory;

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

            CityComponent[] components = { appartment1, appartment2, appartment3, pole1, pole2 };

            for (CityComponent component : components) {
                component.addSensor(factory.createSensor("temperature"));
                component.addSensor(factory.createSensor("noise"));
                component.addSensor(factory.createSensor("pollution"));
                component.addSensor(factory.createSensor("speed"));
            }


            city.display();
        }
    }
