import city.*;

public class Main {
    public static void main(String[] args){
        CityComponent city = new City("City");

        CityComponent neighborhood = new Neighborhood("Neighborhood1");

        CityComponent street1 = new Street("Street1");
        CityComponent street2 = new Street("Street2");
        CityComponent street3 = new Street("Street3");

        CityComponent appartment1 = new Appartment("Appartment1");
        CityComponent appartment2 = new Appartment("Appartment2");
        CityComponent appartment3 = new Appartment("Appartment3");

        CityComponent pole1 = new Pole("Pole1");
        CityComponent pole2 = new Pole("Pole2");

        city.add(neighborhood);

        neighborhood.add(street1);
        neighborhood.add(street2);
        neighborhood.add(street3);

        street1.add(appartment1);
        street1.add(appartment2);
        street3.add(appartment3);

        street1.add(pole1);
        street2.add(pole2);

        city.display();
    }
}
