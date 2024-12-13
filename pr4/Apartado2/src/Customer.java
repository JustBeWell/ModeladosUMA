import java.util.*;
public class Customer {
    private String dni;
    private String name;
    private Set<Rental> rentals;
    public Customer(String dni, String name) {
        this.dni = dni;
        this.name = name;
        rentals = new HashSet<>();
    }
    public String getDni() {
        return dni;
    }public String getName() {
        return name;
    }public void setDni(String dni) {
        this.dni = dni;
    }public void setName(String name) {
        this.name = name;
    }
    public Set<Rental> getRentals() {
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

    @Override
    public boolean equals(Object obj) {
        boolean ok = this == obj;
        if(!ok && obj instanceof Customer){
            Customer other = (Customer) obj;
            ok = dni.equalsIgnoreCase(other.dni);
        }
        return ok;
    }
    @Override
    public int hashCode() {
        return dni.toLowerCase().hashCode();
    }
    @Override
    public String toString() {
        return "[Customer: " + dni + " " + name + "\n" + displayRentals() + "]";
    }

    public String displayRentals(){
        StringBuilder sb = new StringBuilder();
        for(Rental rental : rentals){
            sb.append(rental.toString()).append("\n");
        }
        return sb.toString().trim();
    }

}
