import java.util.*;
public class RentalOnSite extends Rental{
    private String comments;
    
    public RentalOnSite(String comments, Date startDate, Date endDate,Customer customer,Car car,RentalOffice rentalOffice) {
        super(startDate,endDate,customer,car,rentalOffice);
        this.comments = comments;
    }
    
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    @Override
    public Date getStartDate() {
        return super.getStartDate();
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
    public RentalOffice getRentalOffice() {
        return super.getRentalOffice();
    }

    @Override
    public void setRentalOffice(RentalOffice rentalOffice) {
        super.setRentalOffice(rentalOffice);
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
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + " ; " + comments;
    }
}
