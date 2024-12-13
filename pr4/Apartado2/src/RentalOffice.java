import java.util.*;
public class RentalOffice{
    private String address;
    private int feeForDelivery;
    private Set<Car> cars;
    private Set<WebRental> webRentals;
    private Set<Rental> rentals;
    public RentalOffice(String address, int feeForDelivery){
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        cars = new HashSet<>();
        webRentals = new HashSet<>();
        rentals = new HashSet<>();
    }
    public String getAddress() {
        return address;
    }
    public int getFeeForDelivery() {
        return feeForDelivery;
    }

    public Set<Car> getCars() {
        Set<Car> copy = new HashSet<>();
        copy.addAll(cars);
        return copy;
    }
    public Set<WebRental> getWebRentals() {
        Set<WebRental> copy = new HashSet<>();
        copy.addAll(webRentals);
        return copy;    
    }

    public Set<Rental> getRentals() {
        Set<Rental> copy = new HashSet<>();
        copy.addAll(rentals);
        return copy;    
    }

    public void addCar(Car car) {
        cars.add(car);
    }
    public void removeCar(Car car) {
        if(cars.contains(car)) cars.remove(car);
    }
    public void addWebRental(WebRental webRental) {
        webRentals.add(webRental);
    }
    public void removeWebRental(WebRental webRental){
        if(webRentals.contains(webRental)) webRentals.remove(webRental);
    }
    public void addRental(Rental rental){
        rentals.add(rental);
    }
    public void removeRental(Rental rental){
        if(rentals.contains(rental)) rentals.remove(rental);
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setFeeForDelivery(int feeForDelivery) {
        this.feeForDelivery = feeForDelivery;
    }
    @Override
    public boolean equals(Object obj) {
        boolean ok = this == obj;
        if(!ok && obj instanceof RentalOffice){
            RentalOffice other = (RentalOffice) obj;
            ok = address.equalsIgnoreCase(other.address);
        }
        return ok;
    }
    @Override
    public int hashCode() {
        return address.toLowerCase().hashCode();
    }
    @Override
    public String toString() {
        return "[RentalOffice: " + address + " " + feeForDelivery + " ; " + displayCars() + displayRentals() + displayWebRentals() + "]";
    }

    public String displayRentals(){
        StringBuilder sb = new StringBuilder();
        for(Rental rental : rentals){
            sb.append(rental.toString()).append("\n");
        }
        return sb.toString().trim();
    }
    public String displayCars(){
        StringBuilder sb = new StringBuilder();
        for(Car car : cars){
            sb.append(car.toString()).append("\n");
        }
        return sb.toString().trim();
    }
    public String displayWebRentals(){
        StringBuilder sb = new StringBuilder();
        for(WebRental wrental : webRentals){
            sb.append(wrental.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}