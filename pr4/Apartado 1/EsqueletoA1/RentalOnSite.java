import java.util.*;
public class RentalOnSite extends Rental{
    private String comments;
    
    public RentalOnSite(String comments, Date startDate, Date endDate,Customer customer,Car car,RentalOffice rentalOffice) {
        super(startDate,endDate,customer,car,rentalOffice);
        assert comments != null : "Los comentarios no pueden ser nulos";
        this.comments = comments;
    }
    //Se añade un constructor en el que no se fuerza al usuario a meter comentarios ya que no son obligatorios
    public RentalOnSite(Date startDate, Date endDate,Customer customer,Car car,RentalOffice rentalOffice) {
        super(startDate,endDate,customer,car,rentalOffice);
    }
    
    public String getComments() {
        return comments;
    }



    protected void setComments(String comments) {
        assert comments != null;
        this.comments = comments;
    }

    //Hacemos un override para llamar al super? ;)
    /*
    @Override
    public Date getStartDate() {

        return super.getStartDate();
    }
    @Override
    protected void setCar(Car car) {
        super.setCar(car);
    }
    @Override
    public void setStartDate(Date startDate) {
        super.setStartDate(startDate);
    }
    @Override
    public Date getEndDate() {
        return super.getEndDate();
    }

    @Override
    public RentalOffice getPickUpRentalOffice() {
        return super.getPickUpRentalOffice();
    }

    @Override
    public void setPickUpRentalOffice(RentalOffice pickUpRentalOffice) {
        super.setPickUpRentalOffice(pickUpRentalOffice);
    }
    @Override    
    public void setEndDate(Date endDate) {
        super.setEndDate(endDate);
    }
    @Override    
    public Customer getCustomer() {
        return super.getCustomer();
    }
    @Override
    public void setCustomer(Customer customer) {
        super.setCustomer(customer);
    }
    public Car getCar(Car car){
        return super.getCar();
    }
    @Override
    public void setCar(Car car){
        super.setCar(car);
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalOnSite that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comments);
    }

    @Override
    public String toString() {
        return super.toString() + " ; " + comments;
    }


}
