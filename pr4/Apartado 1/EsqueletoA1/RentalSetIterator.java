import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class RentalSetIterator implements RentalIterator {
    private Iterator<Rental> iterator;

    public RentalSetIterator(Set<Rental> rentals) {
        this.iterator = rentals.iterator();
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
