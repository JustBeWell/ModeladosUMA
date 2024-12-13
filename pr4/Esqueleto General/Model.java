import java.util.*;
public class Model {
    private final String name;
    private int pricePerDay;
    private Set<Car> cars;
    
    public Model(String name, int pricePerDay) {
        assert name != null : "Name no puede ser null";
        assert pricePerDay > 0 : "Price per day no puede ser negativo";
        this.name = name;
        this.pricePerDay = pricePerDay;
        cars = new HashSet<>();
    }
    public String getName() {
        return name;
    }
    public int getPricePerDay() {
        return pricePerDay;
    }
    public Set<Car> getCars() {
        //Set<Car> copy = new HashSet<>();
        //copy.addAll(cars);
        return Collections.unmodifiableSet(cars);
    }
    protected void addCar(Car car){
        assert car != null : "Car no puede ser null";
        cars.add(car);

    }
    protected void removeCar(Car car){
        assert car != null : "Car no puede ser null";
        cars.remove(car);

    } // No hace falta poner if(cars.contains(car)), es redudante, la eliminación de elementos no existentes es segura en Java

    protected void setPricePerDay(int pricePerDay) {
        assert (pricePerDay > 0) : "PricePerDay no puede ser negativo";
        this.pricePerDay = pricePerDay;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ok = this == obj;
        if(!ok && obj instanceof Model){
            Model other = (Model) obj;
            ok = name.equalsIgnoreCase(other.name);
        }
        return ok;
    }
    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
    @Override
    public String toString() {
        return "[Model: " + name + " " + pricePerDay + " ; " + displayCars() + "]";
    }

    public String displayCars(){
        StringBuilder sb = new StringBuilder();
        for(Car car : cars){
            sb.append(car.toString()).append("\n");
        }
        return sb.toString();
    }
}
