import java.util.*;

public class Car {
    private String licensePlate; //La licenseplate puede cambiar
    private Set<Rental> rentals;
    private final Model model; //El modelo no
    private  RentalOffice assignedRentalOffice; // Asumiremos que la rental office puede cambiar
    private Estado estado;  // Metemos un atributo que hace referencia al estado del coche que puede ser EnServicio o FueraDeServicio
    private Car sustituto; //Sustituto se concibe como una relación entre coches.
    //private Date fueraDeServicioHasta; El atributo es específico del estado fuera de servicio

    public Car(String licensePlate, Model model, RentalOffice rentalOffice) {
        assert licensePlate != null : "License plate es null";
        assert model != null : "Model es null";
        assert rentalOffice != null : "Rental office es null";
        this.assignedRentalOffice = rentalOffice;
        this.licensePlate = licensePlate;
        this.model = model;
        this.model.addCar(this);
        rentalOffice.addCar(this);       //Garantizamos la bidreccionalidad
        this.estado = new EnServicio(this); // Inicialmente el coche estará en servicio
        this.sustituto = null;          // Inicialmente el coche no tendrá sustituto
        rentals = new HashSet<>();
    }
   /* getter para la oficina asignada*/
    public RentalOffice getAssignedRentalOffice() {
        return assignedRentalOffice;
    }
    /*Setter para asignar la oficina*/
    protected void setAssignedRentalOffice(RentalOffice rentalOffice) {
        //Como el coche tiene que tener asociado una oficina siempre, garantizamos que no sea null
        assert rentalOffice != null : "RentalOffice no puede ser null";
        this.assignedRentalOffice.removeCar(this);
        this.assignedRentalOffice = rentalOffice;
        rentalOffice.addCar(this);
    }
    /*Getter para la placa del coche*/
    public String getLicensePlate() {
        return licensePlate;
    }
    /*Setter para la placa del coche*/
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
    public Estado changeEstado(){
        return this.estado;
    }
    void setEstado(Estado estado){
        this.estado = estado;
    }
    // Getter para obtener el coche sustituto
    public Car getSustituto(){
        return this.sustituto;
    }
    // Setter para asignar el coche sustituto:
    protected void setSustituto(Car car){
        assert car != null : "car no puede ser null";
        assert car.getAssignedRentalOffice().equals(this.getAssignedRentalOffice()) : "El sustituto no está asignado a la misma oficina";
        this.sustituto = car;
    }
    //Getter para obtener la fecha hasta la que el coche estará fuera de servicio:
    /*public Date getFueraDeServicioHasta() {
        return this.fueraDeServicioHasta;
    }*/

    //Setter para asignar la fecha hasta la que el coche estará fuera de servicio:
    /*private void setFueraDeServicioHasta(Date fueraDeServicioHasta) {
        assert fueraDeServicioHasta != null : "fueraDeServicioHasta es null";
        this.fueraDeServicioHasta = fueraDeServicioHasta;
    }*/

    //Para hacer uso del state pattern vamos a llamar al estado en todas las funciones dependientes del estado
    /*takeOutOfService(Date backToService) → Porque el comportamiento depende del estado.
    addRental(Rental rental) → Porque solo en el estado EnServicio se permite añadir alquileres.
    removeRental(Rental rental) → Si también debe depender del estado actual, por ejemplo, si un coche fuera de servicio no puede remover alquileres. */

    protected void addRental(Rental rental) { //Se pone protected para que solo podamos usarlo nostros
       assert rental != null: "El alquiler no puede ser nulo";
       estado.addRental(rental);
        // En servicio
        /*for (Rental existingRental : rentals) {
           assert (!(datesOverlap(existingRental.getStartDate(), existingRental.getEndDate(),
                rental.getStartDate(), rental.getEndDate()))) : ("El alquiler se solapa con otro ya existente.");
        }
        rentals.add(rental);*/
    }

    protected void validateAndAddRental(Rental rental) { //Méto do que solo llama el estado, por lo que estamos delegándole la decisión
        assert rental != null : "Rental no puede ser null";
        for (Rental existingRental : rentals) {
            assert !datesOverlap(existingRental.getStartDate(), existingRental.getEndDate(),
                rental.getStartDate(), rental.getEndDate()) : "El alquiler se solapa con otro ya existente.";
        }
        rentals.add(rental);
    }
   private boolean datesOverlap(Date start1, Date end1, Date start2, Date end2) {
        return !(end1.before(start2) || start1.after(end2));
   }


    protected void removeRental(Rental rental) {
        assert  rental != null : "Rental no puede ser null";
        estado.removeRental(rental);
        /*rentals.remove(rental);*/
        //Los removes se usan exclusivamente en los setters por lo que no es necesario garantizar aqui la bidireccionalidad
    }
    protected void removeRentalAfterValidation(Rental rental){ //De nuevo este mét odo solo se llama desede el estado apropiado
        rentals.remove(rental);
    }

    // Método para poner un coche fuera de servicio
    public void takeOutOfService(Date backToService){

        /* assert estado instanceof  EnServicio : "El coche ya está fuera de servicio";
        // Registramos la cuando el coche vuelva en servicio*/
        assert backToService != null;
        estado.takeOutOfService(backToService);
    }

    public Estado getEstado() {
        return estado;
    }
    // Método privado para encontrar al sustituo
    Car encontrarSustituto(){
        /*Iterator<Car> iter = this.getAssignedRentalOffice().getCars().iterator(); // Obtenemos los coches de la misma oficina
        while(iter.hasNext()){  // Iteramos sobre el conjunto de coches obtenidos
            Car curr = iter.next();
            //Buscamos un coche sustituto que tenga el mismo modelo, esté en servicio y no sea el sustituto del otro coche
            if(curr.getModel().equals(this.getModel())){
                    return curr;
            }
        }
        return null;*/

        //Opción con streams
        return assignedRentalOffice.getCars().stream()
                .filter(car -> car.getModel().equals(this.getModel()) && car.getEstado().sePuedeAlquilar())
                .findFirst().orElse(null);
    }

    // El método para comprobar si el coche actual es sustituto o no
    boolean esSustituto(){
        Iterator<Car> iter = this.getModel().getCars().iterator();
        while(iter.hasNext()){
            Car curr = iter.next();
            if(curr.getSustituto() != null && curr.getSustituto().equals(this))
                return true;
        }
        return false;
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
