import java.util.*;
public class Model {
    private String name;
    private int pricePerDay;
    private Set<Car> cars;
    
    public Model(String name, int pricePerDay) {
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
        Set<Car> copy = new HashSet<>();
        copy.addAll(cars);
        return copy;
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void removeCar(Car car){
        if(cars.contains(car)) cars.remove(car);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPricePerDay(int pricePerDay) {
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
