package city;

import java.util.ArrayList;
import java.util.List;

public class Neighborhood extends CityComponent{
    private List<CityComponent> streets;

    public Neighborhood(String name){
        super(name);
        this.streets = new ArrayList<>();
    }

    @Override
    public void display(){
        System.out.println("    ->Neighborhood: " + name);
        for (CityComponent s : streets) {
            s.display();
        }
    }

    @Override
    public void add(CityComponent component){
        streets.add(component);
    }

    @Override
    public void remove(CityComponent component){
        streets.remove(component);
    }
}
