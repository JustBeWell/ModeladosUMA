import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
public abstract  class Rental {
    private final Date startDate; //No deberían poder mutar las fechas
    private final Date endDate;
    private Customer customer; //El cliente puede cambiar (le paso el contrato a mi padre)
    private Car car; //Vamos a considerar que se puede cambiar de coche
    private RentalOffice pickUpRentalOffice; //Vamos a considerar que se puede cambiar de oficina
    /*Quizás sea mejor no poner cosas como el modelo o la placa de un coche inmutables, para permitir a los usarios cambiarlo en caso de que
    o bien un coche cambie de matrícula (lo cual puede pasar) o bien se hayan confundido al meter el modelo y puedan cambiarlo sin tener que borrar el objeto y todas sus relaciones
*/
    private DescuentoEstrategia descuento;
    public Rental(Date startDate, Date endDate, Customer customer,Car car, RentalOffice rentalOffice,DescuentoEstrategia descuento) {
        assert (startDate.before(endDate)) : "La fecha de inicio debe ser anterior a la de finalización";
        assert startDate != null : "Start date no puede ser null.";
        assert endDate != null : "End date no puede ser null.";
        assert customer != null : "Customer no puede ser null.";
        assert car != null : "Car no puede ser null.";
        assert rentalOffice != null : "Rental office no puede ser null.";
        if(!customer.rentalEsValido(startDate)) throw new AssertionError("La fecha de inicio no es invalida");
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
        this.pickUpRentalOffice = rentalOffice;
        this.descuento = descuento;
        car.addRental(this);
        customer.addRental(this);
        rentalOffice.addRental(this);
        //Garantizamos bidireccionalidad
    }

    public Date getEndDate() {
        return endDate;
    }
    public Date getStartDate() {
        return startDate;
    }

    public Customer getCustomer() {
        return customer;
    }
    public Car getCar(){
        return car;
    }

    public RentalOffice getPickUpRentalOffice() {
        return pickUpRentalOffice;
    }
    public DescuentoEstrategia getDescuento() {
        return descuento;
    }
    //NUEVO METODO PARA OBTENER PRECIO CON DESCUENTO SI EXISTE
    public int getPrice(){
        LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        double diasRental = ChronoUnit.DAYS.between(localStartDate, localEndDate);
        int precioBase = (int) (diasRental * car.getModel().getPricePerDay());
        if(this.descuento != null) return descuento.aplicarDescuento(precioBase);
        return precioBase;
    }

    public void setDescuento(DescuentoEstrategia descuento) {
        this.descuento = descuento;
    }
    
    protected void setPickUpRentalOffice(RentalOffice pickUpRentalOffice) {
        assert pickUpRentalOffice != null : "Rental office no puede ser null.";
        this.pickUpRentalOffice.removeRental(this);
        this.pickUpRentalOffice = pickUpRentalOffice;
        this.pickUpRentalOffice.addRental(this);
    }
    /*public void setEndDate(Date endDate) {
        assert endDate != null : "End date no puede ser null.";
        assert (getStartDate().before(endDate)) : "La fecha de inicio debe ser anterior a la de finalización";

        this.endDate = endDate;
    }*/
    /*public void setStartDate(Date startDate) {
        assert startDate != null : "Start date no puede ser null.";
        assert (startDate.before(getEndDate())) : "La fecha de inicio debe ser anterior a la de finalización";

        this.startDate = startDate;
    }*/

    protected void setCustomer(Customer customer) {
        assert customer != null : "Customer no puede ser null.";
        this.customer.removeRental(this);
        this.customer = customer;
        this.customer.addRental(this);
    }
    protected void setCar(Car car){
        assert car != null : "Car no puede ser null.";
        this.car.removeRental(this);
        this.car = car;
        this.car.addRental(this);
    }


    //Para que dos alquileres sean considerados iguales no basta con que tengan la misma fecha de start y end, tenemos que considerar también el cliente y el coche que se alquila.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental rental)) return false;
        return Objects.equals(startDate, rental.startDate) && Objects.equals(endDate, rental.endDate) && Objects.equals(customer, rental.customer) && Objects.equals(car, rental.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, customer, car);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": " + startDate + " " + endDate+"\n";
    }
}
