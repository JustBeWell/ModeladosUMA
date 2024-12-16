import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class RentalSetIterator implements RentalIterator {
    private Iterator<Rental> iterator;
    private RentalSet rentalSet;


    public RentalSetIterator(RentalSet rentalSet) {
        assert rentalSet != null;
        this.rentalSet = rentalSet;
        this.iterator = rentalSet.getRentals().iterator();
    }



    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Rental next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterator.next();
    }
}
