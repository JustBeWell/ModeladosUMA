import java.util.*;
public class RentalOffice{
    private String address;
    private int feeForDelivery; //Vamos a considerar que tanto la dirección como la fee se pueden mutar
    private Set<Car> cars;
    private Set<WebRental> webRentals;
    private Set<Rental> rentals;

    public RentalOffice(String address, int feeForDelivery){
        assert address != null : "address no puede ser null";
        assert feeForDelivery >= 0 : "feeForDelivery must be positive";
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
        /*Set<Car> copy = new HashSet<>();
        copy.addAll(cars);
        return copy;*/
        return Collections.unmodifiableSet(cars);
    }
    public Set<WebRental> getWebRentals() {
        /*Set<WebRental> copy = new HashSet<>();
        copy.addAll(webRentals);
        return copy;    */
        return Collections.unmodifiableSet(webRentals);
    }

    public Set<Rental> getRentals() {
        /*Set<Rental> copy = new HashSet<>();
        copy.addAll(rentals);
        return copy;    */
        return Collections.unmodifiableSet(rentals);
    }

    protected void addCar(Car car) {
        assert car != null : "car no puede ser null";
        cars.add(car);
    }
    protected void removeCar(Car car) {
        /*if(cars.contains(car))*/
        assert car != null : "car no puede ser null";
        cars.remove(car);
    }
    protected void addWebRental(WebRental webRental) {
        assert webRental != null : "webRental no puede ser null";
        webRentals.add(webRental);
    }
    protected void removeWebRental(WebRental webRental){
        /*if(webRentals.contains(webRental)) */
        assert webRental != null : "webRental no puede ser null";
        webRentals.remove(webRental);
    }
    protected void addRental(Rental rental){
        assert rental != null : "rental no puede ser null";
        rentals.add(rental);
    }
    public void removeRental(Rental rental){
        assert rental != null : "rental no puede ser null";

        /*if(rentals.contains(rental)) */
        rentals.remove(rental);
    }
    protected void setAddress(String address) {
        assert address != null : "address no puede ser null";
        this.address = address;
    }
    protected void setFeeForDelivery(int feeForDelivery) {
        assert feeForDelivery >= 0 : "feeForDelivery must be positive";
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
        return "[RentalOffice: " + address + " " + feeForDelivery + " ; " + cars.toString() + " ; "+ rentals.toString() +" ; "+ webRentals.toString() + "]";
    }
}