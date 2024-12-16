import java.util.*;

public class WebRental extends Rental {
    private Integer deliveryTime;
    private RentalOffice deliveryRentalOffice;

    public WebRental(Integer deliveryTime, Date startDate, Date endDate, Customer customer, Car car, RentalOffice rentalOffice) {
        super(startDate, endDate, customer, car, car.getAssignedRentalOffice());
        assert deliveryTime > 0 : "DeliveryTime debe ser positivo";
        assert rentalOffice != null : "RentalOffice no puede ser null";
        this.deliveryTime = deliveryTime;
        this.deliveryRentalOffice = rentalOffice;

        // Siguiendo el comportamiento de Rental, siempre que creamos una instancia de WebRental lo añadimos a su colección correspondiente
        this.getPickUpRentalOffice().addWebRental(this);
    }

    /**
     * El constructor de WebRental recibe en el parámetro "RentalOffice rentalOffice" el lugar de RECOGIDA
     *
     * Cuando llamamos al super(), recuperando los datos de un Rental que por ser una clase abstracta, WebRental heredará todos los atributos
     * y los extiende con los suyos; es una especificación de Rental. Es por eso que necesitamos pasarle a Rental "car.getAssignedRentalOffice()"
     * porque en ese constructor estamos definiendo el "pickUpRentalOffice" que es donde se encuentra el coche actualmente.
     *
     * Entonces RentalOffice rentalOffice se asigna al deliveryRentalOffice que viene del Test al momento de crear una instancia de WebRental
     */

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public Date getStartDate() {
        return super.getStartDate();
    }


    protected void setDeliveryTime(Integer deliveryTime) {
        assert deliveryTime > 0 : "DeliveryTime debe ser positivo";
        this.deliveryTime = deliveryTime;
    }

    public RentalOffice getDeliveryRentalOffice(){
        assert deliveryRentalOffice != null: "La deliveryOffice para alquiler tipo Web no puede ser nulo";
        return deliveryRentalOffice;
    }

    protected void setDeliveryRentalOffice(RentalOffice deliveryRentalOffice) {
        assert deliveryRentalOffice != null : "RentalOffice no puede ser null";
        this.deliveryRentalOffice.removeWebRental(this);
        /**
         * ¿Por qué usamos un remove antes de un add?
         * El removeWebRental se utiliza como medida de seguridad en caso de que el dato original sea erróneo. Ahora siempre nos
         * aseguramos de añadir (en la línea siguiente) el deliveryRentalOffice correcto tras borrar su instancia actual; utilizamos
         * la nueva.
         */
        this.deliveryRentalOffice = deliveryRentalOffice;
        this.deliveryRentalOffice.addWebRental(this);
    }

    //JEJE GOD
    /*
    @Override
    public Date getEndDate() {
        return super.getEndDate();
    }
    @Override
    public Customer getCustomer(){
        return super.getCustomer();
    }
    @Override
    public Car getCar(){
        return super.getCar();
    }

    @Override
    public RentalOffice getPickUpRentalOffice() {
        return deliveryRentalOffice;
    }

    @Override
    public void setPickUpRentalOffice(RentalOffice pickUpRentalOffice) {
        this.deliveryRentalOffice = pickUpRentalOffice;
    }
    @Override
    public void setCar(Car car){
        super.setCar(car);
    }
    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    @Override
    public void setStartDate(Date startDate) {
        super.setStartDate(startDate);
    }
    @Override
    public void setEndDate(Date endDate) {
        super.setEndDate(endDate);
    }
    @Override
    public void setCustomer(Customer customer){
        super.setCustomer(customer);
    }

      }*/


    @Override
    public String toString() {
        return super.toString() + " ; " + deliveryTime.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebRental webRental)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(deliveryTime, webRental.deliveryTime) && Objects.equals(deliveryRentalOffice, webRental.deliveryRentalOffice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deliveryTime, deliveryRentalOffice);
    }

}