import java.util.*;
public class WebRental extends Rental{
    private Integer deliveryTime;
    private RentalOffice rentalOffice;
    public WebRental(Integer deliveryTime, Date startDate, Date endDate,Customer customer,Car car,RentalOffice rentalOffice){
        super(startDate, endDate,customer,car,rentalOffice);
        this.deliveryTime = deliveryTime;
        this.rentalOffice = rentalOffice;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }
    public Date getStarDate(){
        return super.getStartDate();
    }
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
    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }

    @Override
    public void setRentalOffice(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
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
        return super.toString() + " ; " + deliveryTime.toString();
    }
}
