import java.util.*;
public class Customer {
    private final String dni;
    private final String name; //No vamos a permitir que cambien el dni o el nombre
    private Set<Rental> rentals;
    public Customer(String dni, String name) {
        assert  dni != null : "dni no puede ser null";
        assert  name != null : "name no puede ser null";
        this.dni = dni;
        this.name = name;
        rentals = new HashSet<>();
    }
    public String getDni() {
        return dni;
    }
    public String getName() {
        return name;
    }

    public Set<Rental> getRentals() {
       // Set<Rental> copy = new HashSet<>();
        //copy.addAll(rentals);
        return Collections.unmodifiableSet(rentals);
    }

    protected void addRental(Rental rental) {
        assert rental != null : "rental no puede ser null";
        rentals.add(rental);
    }
    protected void removeRental(Rental rental) {
        assert rental != null : "rental no puede ser null";
        rentals.remove(rental);
    }

    /**
     * Devuelve el número de alquileres web donde las oficinas de recogida y entrega son diferentes.
     */
    public Integer numberOfRentalsWithDifferentOffices() {
        int count = 0;
        RentalIterator iterator = this.getRentalIterator();

        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            if (rental instanceof WebRental) { // Verificamos si es un WebRental
                WebRental webRental = (WebRental) rental;
                if (!webRental.getPickUpRentalOffice().equals(webRental.getDeliveryRentalOffice())) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Este cliente usa un iterador para recorrer los alquileres.
     */
    public RentalIterator getRentalIterator() {
        return new RentalSetIterator(this.rentals);
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
        return "[Customer: " + dni + " " + name + "\n" + rentals.toString() + "]";
    }

    public String displayRentals(){
        StringBuilder sb = new StringBuilder();
        for(Rental rental : rentals){
            sb.append(rental.toString()).append("\n");
        }
        return sb.toString().trim();
    }

}
