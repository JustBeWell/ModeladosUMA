import java.util.*;
public class Car {
    private String licensePlate; //La licenseplate puede cambiar
    private Set<Rental> rentals;
    private final Model model; //El modelo no
    private  RentalOffice assignedRentalOffice; // Asumiremos que la rental office puede cambiar


    public Car(String licensePlate, Model model, RentalOffice rentalOffice) {
        assert licensePlate != null : "License plate es null";
        assert model != null : "Model es null";
        assert rentalOffice != null : "Rental office es null";
        this.assignedRentalOffice = rentalOffice;
        this.licensePlate = licensePlate;
        this.model = model;
        this.model.addCar(this);
        rentalOffice.addCar(this); //Garantizamos bidreccionalidad

        rentals = new HashSet<>();
    }
    public RentalOffice getAssignedRentalOffice() {
        return assignedRentalOffice;
    }

    protected void setAssignedRentalOffice(RentalOffice rentalOffice) {
        //Como el coche tiene que tener asociado una oficina siempre, garantizamos que no sea null
        assert rentalOffice != null : "RentalOffice no puede ser null";
        this.assignedRentalOffice.removeCar(this);
        this.assignedRentalOffice = rentalOffice;
        rentalOffice.addCar(this);
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    protected void setLicensePlate(String licensePlate) {
        assert licensePlate != null : "License plate es null";
        this.licensePlate = licensePlate;
    }
    public Model getModel() {
        return model;
    }

    public Set<Rental> getRentals(){
        //Set<Rental> copy = new HashSet<>();
        //copy.addAll(rentals);

        return Collections.unmodifiableSet(rentals); // La copia y sus elementos no son mutables.
    }

   protected void addRental(Rental rental) { //Se pone protected para que solo podamos usarlo nostros
        assert rental != null : "Rental es null";
    for (Rental existingRental : rentals) {
        assert (!(datesOverlap(existingRental.getStartDate(), existingRental.getEndDate(),
                         rental.getStartDate(), rental.getEndDate()))):("El alquiler se solapa con otro ya existente.");
    }

    rentals.add(rental);
}

private boolean datesOverlap(Date start1, Date end1, Date start2, Date end2) {
    return !(end1.before(start2) || start1.after(end2));
}

    protected void removeRental(Rental rental) {
        assert  rental != null : "Rental no puede ser null";
        rentals.remove(rental);
        //Los removes se usan exclusivamente en los setters por lo que no es necesario garantizar aqui la bidireccionalidad
    }

    
    /*public void setLicensePlate(String licensePlate) {
        assert licensePlate != null : "License plate es null";
        this.licensePlate = licensePlate;
    }
    public void setModel(Model model) {
        assert model != null : "Model es null";
        this.model = model;
        this.model.removeCar(this);
        model.addCar(this); //garantizar bidireccionalidad
    }*/
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
        return "Car: " + licensePlate;
    }

    public String displayRentals(){
        StringBuilder sb = new StringBuilder();
        for(Rental rental : rentals){
            sb.append(rental.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
