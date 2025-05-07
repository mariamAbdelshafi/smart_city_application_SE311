package city;

import java.util.ArrayList;
import java.util.List;

public class City extends CityComponent{
    private List<CityComponent> neighborhoods;

    public City(String name){
        super(name);
        this.neighborhoods = new ArrayList<>();
    }

    @Override
    public void display(){
        System.out.println("City: " + name);
        for(CityComponent n : neighborhoods){
            n.display();
        }
    }

    @Override
    public void add(CityComponent component){
        neighborhoods.add(component);
    }

    @Override
    public void remove(CityComponent component){
        neighborhoods.remove(component);
    }
}

