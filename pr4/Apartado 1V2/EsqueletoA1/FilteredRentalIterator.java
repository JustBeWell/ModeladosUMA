import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteredRentalIterator implements RentalIterator{
    private Iterator<Rental> iterator;
    private RentalSet rentalSet;
    private Rental nextRental;

    public FilteredRentalIterator(RentalSet rentalSet) {
        assert rentalSet != null;
        this.rentalSet = rentalSet;
        this.iterator = rentalSet.getRentals().iterator();
        moveToNextValid();

    }
    private void moveToNextValid() {
        nextRental = null;
        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            if (rental instanceof WebRental) {
                WebRental webRental = (WebRental) rental;
                if (!webRental.getPickUpRentalOffice().equals(webRental.getDeliveryRentalOffice())) {
                    nextRental = rental;
                    break;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextRental != null;
    }

    @Override
    public Rental next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Rental current = nextRental;
        moveToNextValid();
        return current;
    }
}
