import java.util.*;
public abstract  class Rental {
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private Car car;
    private RentalOffice rentalOffice;
    public Rental(Date startDate, Date endDate, Customer customer,Car car, RentalOffice rentalOffice) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
        this.rentalOffice = rentalOffice;
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

    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }
    public void setRentalOffice(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setCar(Car car){
        this.car = car;
    }
    @Override
    public boolean equals(Object obj) {
        boolean ok = this == obj;
        if(!ok && obj instanceof Rental){
            Rental other = (Rental) obj;
            ok = this.startDate.equals(other.startDate) && this.endDate.equals(other.endDate);
        }
        return ok;
    }
    @Override
    public int hashCode() {
        return startDate.hashCode() + endDate.hashCode();
    }
    @Override
    public String toString() {
        return this.getClass().getName() + ": " + startDate + " " + endDate;
    }
}
