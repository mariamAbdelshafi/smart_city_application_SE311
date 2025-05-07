package city;

public class Appartment extends CityComponent{
    public Appartment(String name){
        super(name);
    }

    @Override
    public void display(){
        System.out.println("            Appartment: " + name);
    }

    @Override
    public void add(CityComponent component){
        throw new UnsupportedOperationException("An appartment can't contain another component");
    }

    @Override
    public void remove(CityComponent component){
        throw new UnsupportedOperationException("An appartment can't contain another component");
    }
}
