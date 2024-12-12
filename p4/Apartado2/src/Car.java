import java.util.*;
public class Car {
    private String licensePlate;
    private Set<Rental> rentals;
    private Model model;
    private RentalOffice rentalOffice;
    private Estado estado;
    private Date fueraDeServicioHasta;
    private boolean esSustituto;

    public Car(String licensePlate, Model model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentals = new HashSet<>();
        this.estado = new EnServicio();
        this.rentalOffice = null;
        this.fueraDeServicioHasta = null;
        this.esSustituto = false;
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
    public Estado getEstado(){
        return estado;
    }
    public RentalOffice getRentalOffice(){
        return rentalOffice;
    }
    public boolean esSustituto(){
        return esSustituto;
    }

    public void rent(Rental rental){estado.rent(rental, this);}
    public void addRental(Rental rental) {rentals.add(rental);}
    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public void setRentalOffice(RentalOffice rentalOffice){
        this.rentalOffice = rentalOffice;
    }
    public void setEsSustituto(boolean val){
        this.esSustituto = val;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void takeoutOfService(Date backToService){
         assert estado instanceof EnServicio : "El coche ya está fuera de servicio";
         this.estado = new FueraDeServicio();  // Ponemos el coche fuera de servicio
         this.fueraDeServicioHasta = backToService;  // Registramos la fecha hasta la que el coche no estará disponible
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
