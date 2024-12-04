import java.util.*;
public class Car {
    private String licensePlate;
    private Set<Rental> rentals;
    private Model model;
    public Car(String licensePlate, Model model) {
        this.licensePlate = licensePlate;
        this.model = model;
        rentals = new HashSet<>();
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public Model getModel() {
        return model;
    }
    public Set<Rental> getRentals(){
        Set<Rental> copy = new HashSet<>();
        copy.addAll(rentals);
        return copy;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    @Override
    public boolean equals(Object obj) {
        boolean ok = this == obj;
        if(!ok && obj instanceof Car){
            Car other = (Car) obj;
            ok = licensePlate.equalsIgnoreCase(other.licensePlate);
        }
        return ok;
    }
    @Override
    public int hashCode() {
        return licensePlate.toLowerCase().hashCode();
    }
    @Override
    public String toString() {
        return "[Car: " + licensePlate + " ; " + displayRentals() + "]";
    }

    public String displayRentals(){
        StringBuilder sb = new StringBuilder();
        for(Rental rental : rentals){
            sb.append(rental.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
