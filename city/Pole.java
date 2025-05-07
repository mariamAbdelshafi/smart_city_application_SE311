package city;

public class Pole extends CityComponent{
    public Pole(String name){
        super(name);
    }

    @Override
    public void display(){
        System.out.println("            Pole: " + name);
    }

    @Override
    public void add(CityComponent component){
        throw new UnsupportedOperationException("A pole can't contain another component");
    }

    @Override
    public void remove(CityComponent component){
        throw new UnsupportedOperationException("A pole can't contain another component");
    }
}
