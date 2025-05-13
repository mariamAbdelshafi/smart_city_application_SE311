package city;

import java.util.ArrayList;
import java.util.List;

//composite can contain appartments and poles
public class Street extends CityComponent{
    private List<CityComponent> appartments;
    private List<CityComponent> poles;

    public Street(String name){
        super(name);
        this.appartments = new ArrayList<>();
        this.poles = new ArrayList<>();
    }

    @Override
    public void display(){
        System.out.println("        ->Street: " + name);
        for (CityComponent a : appartments){
            a.display();
        }
        for (CityComponent p : poles){
            p.display();
        }

    }

    @Override
    public void add(CityComponent component){
        if(component instanceof Appartment){
            appartments.add(component);
        }
        else if(component instanceof Pole){
            poles.add(component);
        }
    }

    @Override
    public void remove(CityComponent component){
        if(component instanceof Appartment){
            appartments.remove(component);
        }
        else if(component instanceof Pole){
            poles.remove(component);
        }
    }
}
